package com.trendinghub.domain.usecase

import com.trendinghub.common.ResultState
import com.trendinghub.domain.model.TrendingData
import kotlinx.coroutines.flow.Flow

interface FetchTrendingListUseCase {
    operator fun invoke() : Flow<ResultState<List<TrendingData>>>
}