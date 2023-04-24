package com.trendinghub.domain.repository

import com.trendinghub.common.ResultState
import com.trendinghub.domain.model.TrendingData
import kotlinx.coroutines.flow.Flow

interface TrendingRepository {
    fun fetchTrendingList(): Flow<ResultState<List<TrendingData>>>
}