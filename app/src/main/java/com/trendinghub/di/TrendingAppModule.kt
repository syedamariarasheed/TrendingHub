package com.trendinghub.di

import com.trendinghub.data.remote.source.TrendingRemoteDataSource
import com.trendinghub.data.remote.source.TrendingRemoteDataSourceImpl
import com.trendinghub.data.repository.TrendingRepositoryImpl
import com.trendinghub.domain.repository.TrendingRepository
import com.trendinghub.domain.usecase.FetchTrendingListUseCase
import com.trendinghub.domain.usecase.FetchTrendingListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TrendingAppModule {


    @Binds
    abstract fun provideFetchTrendingListUseCase(fetchTrendingListUseCaseImpl: FetchTrendingListUseCaseImpl): FetchTrendingListUseCase

    @Binds
    abstract fun provideFetchTrendingRepository(trendingRepositoryImpl: TrendingRepositoryImpl): TrendingRepository

    @Binds
    abstract fun provideTrendingRemoteDataSource(trendingRemoteDataSourceImpl: TrendingRemoteDataSourceImpl): TrendingRemoteDataSource

}