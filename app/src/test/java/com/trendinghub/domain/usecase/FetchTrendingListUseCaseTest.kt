package com.trendinghub.domain.usecase

import app.cash.turbine.test
import com.MainDispatcherRule
import com.trendinghub.common.ResultState
import com.trendinghub.domain.repository.TrendingRepository
import com.trendinghub.ui.common.MockProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class FetchTrendingListUseCaseTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val repository: TrendingRepository = mock()

   private var fetchTrendingListUseCase : FetchTrendingListUseCase = FetchTrendingListUseCaseImpl(repository)

    @Test
    fun fetchTrendingListSuccess() = runTest {
        whenever(repository.fetchTrendingList()).thenReturn(flow {
            emit(
                ResultState.Success(
                    listOf(MockProvider.getTrendingData())
                )
            )
        })


        fetchTrendingListUseCase().test {
            val result = awaitItem()
            result as ResultState.Success
            Assert.assertNotNull(result.data)
            Assert.assertEquals("Maria", result.data.first().userName)
            awaitComplete()
        }
    }


}