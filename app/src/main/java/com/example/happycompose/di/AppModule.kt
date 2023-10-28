package com.example.happycompose.di

import com.example.happycompose.data.local.contracts.FeedRepository
import com.example.happycompose.data.local.impl.FeedRepositoryImpl
import com.example.happycompose.data.remote.contracts.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideFeedRepository(apiService: ApiService): FeedRepository {
        return FeedRepositoryImpl(apiService)
    }
}