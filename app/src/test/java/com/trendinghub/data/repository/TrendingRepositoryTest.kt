package com.trendinghub.data.repository

import app.cash.turbine.test
import com.MainDispatcherRule
import com.trendinghub.common.ResultState
import com.trendinghub.data.remote.source.TrendingRemoteDataSource
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
class TrendingRepositoryTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val trendingRemoteDataSource: TrendingRemoteDataSource = mock()

    private val repository: TrendingRepository = TrendingRepositoryImpl(trendingRemoteDataSource)

    @Test
    fun fetchTrendingListSuccess() = runTest {
        whenever(trendingRemoteDataSource.fetchTrendingList()).thenReturn(flow {
            emit(
                ResultState.Success(
                    MockProvider.getTrendingResponseData()
                )
            )
        })

        repository.fetchTrendingList().test {
            val result = awaitItem() as ResultState.Success
            Assert.assertNotNull(result.data)
            Assert.assertEquals("Maria", result.data.first().userName)
            Assert.assertEquals("TrendingHub", result.data.first().repoName)
            Assert.assertEquals(1000, result.data.first().stargazersCount)
            Assert.assertEquals("Kotlin", result.data.first().language)
            awaitComplete()
        }

    }

    @Test
    fun fetchTrendingListFailure() = runTest {
        whenever(trendingRemoteDataSource.fetchTrendingList()).thenReturn(flow {
            emit(
                ResultState.Error(
                    "error"
                )
            )
        })

        repository.fetchTrendingList().test {
            val result = awaitItem() as ResultState.Error
            Assert.assertEquals("error",result.message)
            awaitComplete()
        }

    }
}