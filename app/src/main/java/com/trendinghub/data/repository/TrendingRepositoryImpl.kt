package com.trendinghub.data.repository

import com.trendinghub.common.ResultState
import com.trendinghub.domain.model.TrendingData
import com.trendinghub.domain.repository.TrendingRepository
import kotlinx.coroutines.flow.Flow

class TrendingRepositoryImpl : TrendingRepository {
    override fun fetchTrendingList(): Flow<ResultState<List<TrendingData>>> {
        TODO("Not yet implemented")
    }
}