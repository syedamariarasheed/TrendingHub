package com.trendinghub.domain.usecase

import com.trendinghub.common.network.ResultState
import com.trendinghub.domain.model.TrendingData
import com.trendinghub.domain.repository.TrendingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchTrendingListUseCaseImpl @Inject constructor(private val repository: TrendingRepository) :
    FetchTrendingListUseCase {

    override operator fun invoke(): Flow<ResultState<List<TrendingData>>> {
        return repository.fetchTrendingList()
    }

}