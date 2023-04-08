package com.trendinghub.ui

import com.trendinghub.domain.model.TrendingData

sealed class TrendingUiState {
    object Loading : TrendingUiState()
    data class TrendingList(val data: List<TrendingData>) : TrendingUiState()
    object Empty : TrendingUiState()
    object Error : TrendingUiState()
}
