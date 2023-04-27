package com.trendinghub.data.remote.source

import com.trendinghub.common.ResultState
import com.trendinghub.data.remote.ApiService
import com.trendinghub.data.remote.source.model.TrendingResponseData
import kotlinx.coroutines.flow.Flow

class TrendingRemoteDataSourceImpl(
    private val apiService: ApiService
) : TrendingRemoteDataSource {
    override fun fetchTrendingList(): Flow<ResultState<List<TrendingResponseData>>> {
        TODO("Not yet implemented")
    }
}