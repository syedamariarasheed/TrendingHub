package com.trendinghub.data.remote.source

import app.cash.turbine.test
import com.MainDispatcherRule
import com.trendinghub.common.ResultState
import com.trendinghub.data.remote.ApiService
import com.trendinghub.ui.common.MockProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class TrendingRemoteDataSourceTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val apiService: ApiService = mock()

    private val trendingRemoteDataSource : TrendingRemoteDataSource =
        TrendingRemoteDataSourceImpl(apiService)

    @Test
    fun fetchTrendingListSuccess() = runTest {
        val mockResponse = MockProvider.getTrendingResponseData()
        whenever(apiService.fetchTrendingList()).thenReturn(
            mockResponse
        )

        trendingRemoteDataSource.fetchTrendingList().test {
            val result = awaitItem()
            Assert.assertTrue(result is ResultState.Success)
            assertEquals(mockResponse, (result as ResultState.Success).data)
            awaitComplete()
        }
    }
}