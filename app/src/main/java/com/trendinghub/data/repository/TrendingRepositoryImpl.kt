package com.trendinghub.data.repository

import com.trendinghub.common.network.ResultState
import com.trendinghub.data.mapper.toTrendingData
import com.trendinghub.data.remote.source.TrendingRemoteDataSource
import com.trendinghub.domain.model.TrendingData
import com.trendinghub.domain.repository.TrendingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TrendingRepositoryImpl @Inject constructor(
    private val trendingRemoteDataSource: TrendingRemoteDataSource
) : TrendingRepository {
    override fun fetchTrendingList(): Flow<ResultState<List<TrendingData>>> =
        trendingRemoteDataSource.fetchTrendingList().map {
            when (it) {
                is ResultState.Success -> {
                    ResultState.Success(it.data.items.map { it.toTrendingData() })
                }

                is ResultState.Error -> {
                    it
                }
            }
        }

}