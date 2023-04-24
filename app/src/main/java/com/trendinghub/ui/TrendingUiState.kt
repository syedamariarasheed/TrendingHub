package com.trendinghub.ui

import com.trendinghub.domain.model.TrendingData

sealed class TrendingUiState {
    object Loading : TrendingUiState()
    data class TrendingList(val data: List<TrendingData>) : TrendingUiState()
    data class Error(val message: String) : TrendingUiState()
}
