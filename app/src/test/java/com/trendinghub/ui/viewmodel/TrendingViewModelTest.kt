package com.trendinghub.ui.viewmodel

import app.cash.turbine.test
import com.trendinghub.ui.TrendingUiState
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test


internal class TrendingViewModelTest {

    private val viewModel = TrendingViewModel()

    @Test
    fun validateInitialState_Loading() = runTest {
        viewModel.trendingUiState.test {
            Assert.assertTrue(awaitItem() is TrendingUiState.Loading)
        }
    }

}