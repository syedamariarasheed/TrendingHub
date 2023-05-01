package com.trendinghub.data.remote.source

import app.cash.turbine.test
import com.MainDispatcherRule
import com.trendinghub.common.network.ResultState
import com.trendinghub.data.remote.ApiService
import com.trendinghub.ui.common.MockProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.HttpException

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

    @Test
    fun fetchTrendingList_HttpException() = runTest {
        whenever(apiService.fetchTrendingList()).thenThrow(
            HttpException::class.java
        )

        trendingRemoteDataSource.fetchTrendingList().test {
            val result = awaitItem()
            Assert.assertTrue(result is ResultState.Error)
            assertEquals("An alien is probably blocking your signal", (result as ResultState.Error).message)
            awaitComplete()
        }
    }

    @Test
    fun fetchTrendingList_IOException() = runTest {
        doAnswer { throw java.io.IOException("") }.`when`(apiService)
            .fetchTrendingList()

        trendingRemoteDataSource.fetchTrendingList().test {
            val result = awaitItem()
            Assert.assertTrue(result is ResultState.Error)
            assertEquals("Check your network connectivity", (result as ResultState.Error).message)
            awaitComplete()
        }
    }

    @Test
    fun fetchTrendingList_UnknownException() = runTest {
        doAnswer { throw UnknownError("") }.`when`(apiService)
            .fetchTrendingList()

        trendingRemoteDataSource.fetchTrendingList().test {
            val result = awaitItem()
            Assert.assertTrue(result is ResultState.Error)
            assertEquals("Unknown error", (result as ResultState.Error).message)
            awaitComplete()
        }
    }
}