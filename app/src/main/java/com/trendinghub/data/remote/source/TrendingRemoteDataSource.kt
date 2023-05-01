package com.trendinghub.data.remote.source

import com.trendinghub.common.network.ResultState
import com.trendinghub.data.remote.source.model.TrendingResponseData
import kotlinx.coroutines.flow.Flow

interface TrendingRemoteDataSource {
    fun fetchTrendingList(): Flow<ResultState<TrendingResponseData>>
}