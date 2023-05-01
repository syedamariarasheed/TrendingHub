package com.trendinghub.ui.viewmodel

import app.cash.turbine.test
import com.MainDispatcherRule
import com.trendinghub.common.network.ResultState
import com.trendinghub.domain.usecase.FetchTrendingListUseCase
import com.trendinghub.ui.TrendingUiState
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
class TrendingViewModelTest {

    // Set Main dispatcher to not run coroutines eagerly
    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val fetchTrendingList: FetchTrendingListUseCase = mock()

    private val viewModel = lazy {
        TrendingViewModel(fetchTrendingList)
    }

    @Test
    fun validateInitialState_Loading() = runTest {
        viewModel.value.trendingUiState.test {
            Assert.assertTrue(awaitItem() is TrendingUiState.Loading)
        }
    }

    @Test
    fun validateStateFetchTrendingList_Success() = runTest {
        whenever(fetchTrendingList()).thenReturn(flow {
            emit(
                ResultState.Success(
                    listOf(MockProvider.getTrendingData())
                )
            )
        })

        viewModel.value.trendingUiState.test {
            Assert.assertTrue(awaitItem() is TrendingUiState.Loading)
            val result = awaitItem()
            Assert.assertTrue(result is TrendingUiState.TrendingList)
            result as TrendingUiState.TrendingList
            Assert.assertTrue(result.data.isNotEmpty())
            Assert.assertEquals("Maria", result.data.first().userName)
            Assert.assertEquals("TrendingHub", result.data.first().repoName)
            Assert.assertEquals(1000, result.data.first().stargazersCount)
            Assert.assertEquals("Kotlin", result.data.first().language)
        }
    }

    @Test
    fun validateStateFetchTrendingList_Failure() = runTest {

        whenever(fetchTrendingList()).thenReturn(flow {
            emit(
                ResultState.Error(
                    "Network error"
                )
            )
        })

        viewModel.value.trendingUiState.test {
            Assert.assertTrue(awaitItem() is TrendingUiState.Loading)
            val result = awaitItem()
            Assert.assertTrue(result is TrendingUiState.Error)
            result as TrendingUiState.Error
            Assert.assertEquals("Network error", result.message)
        }
    }

}