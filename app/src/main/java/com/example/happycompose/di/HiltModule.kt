package com.example.happycompose.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class HiltModule {

//    @Provides
//    fun provideFeedRepository(apiService: ApiService): FeedRepository {
//        return FeedRepositoryImpl(apiService)
//    }
//
//    @Provides
//    fun provideUserRepository(apiService: ApiService): UserRepository {
//        return UserRepositoryImpl(apiService)
//    }
}