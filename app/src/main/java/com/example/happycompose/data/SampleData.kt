package com.example.happycompose.data

import com.example.happycompose.data.models.Media
import com.example.happycompose.data.models.MediaType
import com.example.happycompose.data.models.Post
import com.example.happycompose.data.models.SingleStoryItem
import com.example.happycompose.data.models.User
import kotlin.random.Random

object SampleData {
    val user = User("1", "username", "displayName", "https://i.pravatar.cc/300")
    val medias = mutableListOf(
        Media(id = "1", type = MediaType.Image, url = "https://picsum.photos/200"),
        Media(id = "2", type = MediaType.Image, url = "https://picsum.photos/200"),
    )
    private val stories = mutableListOf<SingleStoryItem>()
    val storyList = stories

    init {
        repeat(4) {
            val random = Random.nextInt(0, 100).toString()
            val s = SingleStoryItem(random, "$random title", user, medias)
            stories.add(s)
        }
    }

    val singleStoryItem = SingleStoryItem("1", "title", user, medias)

    val singlePostItem = Post(
        id = "541",
        user = user,
        medias = medias,
        likesTotal = 886,
        commentsTotal = 114,
        viewsTotal = 196,
        shareUrl = "http://app.fakeUrl.com/364",
        description = null
    )
}