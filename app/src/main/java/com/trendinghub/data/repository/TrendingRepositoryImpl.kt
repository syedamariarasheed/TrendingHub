package com.trendinghub.data.repository

import com.trendinghub.common.ResultState
import com.trendinghub.data.mapper.toTrendingData
import com.trendinghub.data.remote.source.TrendingRemoteDataSource
import com.trendinghub.domain.model.TrendingData
import com.trendinghub.domain.repository.TrendingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingRepositoryImpl @Inject constructor(
    private val trendingRemoteDataSource: TrendingRemoteDataSource
) : TrendingRepository {
    override fun fetchTrendingList(): Flow<ResultState<List<TrendingData>>> = flow {
        trendingRemoteDataSource.fetchTrendingList().collect {
            when (it) {
                is ResultState.Success -> {
                    val result = it.data.flatMap { it.items.map { it.toTrendingData() } }
                    emit(ResultState.Success(result))
                }

                else -> {}
            }
        }
    }
}