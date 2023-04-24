package com.trendinghub.ui.viewmodel

import com.trendinghub.ui.TrendingUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class TrendingViewModel {

    private val _trendingUiState =
        MutableStateFlow<TrendingUiState>(TrendingUiState.Loading)
    val trendingUiState: StateFlow<TrendingUiState> =
        _trendingUiState
}