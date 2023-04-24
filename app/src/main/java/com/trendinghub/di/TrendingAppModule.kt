package com.trendinghub.di

import com.trendinghub.data.repository.TrendingRepositoryImpl
import com.trendinghub.domain.repository.TrendingRepository
import com.trendinghub.domain.usecase.FetchTrendingListUseCase
import com.trendinghub.domain.usecase.FetchTrendingListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TrendingAppModule {

    @Provides
    fun provideFetchTrendingListUseCase(repository: TrendingRepository): FetchTrendingListUseCase {
        return FetchTrendingListUseCaseImpl(repository)
    }

    @Provides
    fun provideFetchTrendingRepository(): TrendingRepository {
        return TrendingRepositoryImpl()
    }
}