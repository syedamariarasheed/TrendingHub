package com.trendinghub.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.trendinghub.common.network.MoshiArrayListJsonAdapter
import com.trendinghub.data.remote.ApiService
import com.trendinghub.data.remote.source.TrendingRemoteDataSource
import com.trendinghub.data.remote.source.TrendingRemoteDataSourceImpl
import com.trendinghub.data.repository.TrendingRepositoryImpl
import com.trendinghub.domain.repository.TrendingRepository
import com.trendinghub.domain.usecase.FetchTrendingListUseCase
import com.trendinghub.domain.usecase.FetchTrendingListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object TrendingAppModule {

    @Provides
    fun provideFetchTrendingListUseCase(repository: TrendingRepository): FetchTrendingListUseCase {
        return FetchTrendingListUseCaseImpl(repository)
    }

    @Provides
    fun provideFetchTrendingRepository(trendingRemoteDataSource: TrendingRemoteDataSource): TrendingRepository {
        return TrendingRepositoryImpl(trendingRemoteDataSource)
    }

    @Provides
    fun provideTrendingRemoteDataSource(apiService: ApiService): TrendingRemoteDataSource {
        return TrendingRemoteDataSourceImpl(apiService)
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRetrofit(
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(MoshiArrayListJsonAdapter.FACTORY)
            .build()
    }

}