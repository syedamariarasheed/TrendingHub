package com.trendinghub.data.remote.source

import com.trendinghub.common.network.ResultState
import com.trendinghub.common.network.safeApiCall
import com.trendinghub.data.remote.ApiService
import com.trendinghub.data.remote.source.model.TrendingResponseData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TrendingRemoteDataSourceImpl(
    private val apiService: ApiService
) : TrendingRemoteDataSource {
    override fun fetchTrendingList(): Flow<ResultState<TrendingResponseData>> = flow {
        emit(
            safeApiCall {
                apiService.fetchTrendingList()
            }
        )
    }
}
