package com.example.happycompose.ui.feature.feed

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.happycompose.data.handleApi
import com.example.happycompose.data.models.Post
import com.example.happycompose.data.remote.NetworkResult
import com.example.happycompose.data.remote.contracts.ApiService

// TODO: change all feed naming to post
class FeedPagingSource(
    private val apiService: ApiService,
    private val updateFeeds: (List<Post>) -> Unit
) : PagingSource<Int, Post>() {

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        var _pagingData: MutableList<Post> = mutableListOf()

        return try {
            val nextPage = params.key ?: 1
            val res = handleApi {
                apiService.getFeeds(nextPage, 8)
            }

            when (res) {
                is NetworkResult.Success -> {
                    res.data?.let {
                        _pagingData.addAll(it.feeds)
                        updateFeeds(it.feeds)
                    }
                }
                is NetworkResult.Error -> {
                    return LoadResult.Error(Exception(res.message))
                }
                else -> {
                    return LoadResult.Error(Exception("Something went wrong"))
                }
            }
            LoadResult.Page(
                data = _pagingData,
                prevKey = if (nextPage == 1) null else nextPage.minus(1),
                nextKey = if (_pagingData.isEmpty()) null else nextPage.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
