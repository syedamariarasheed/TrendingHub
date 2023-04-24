package com.trendinghub.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trendinghub.common.ResultState
import com.trendinghub.domain.usecase.FetchTrendingListUseCase
import com.trendinghub.ui.TrendingUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class TrendingViewModel
constructor(val fetchTrendingListUseCase: FetchTrendingListUseCase) : ViewModel() {

    private val _trendingUiState =
        MutableStateFlow<TrendingUiState>(TrendingUiState.Loading)
    val trendingUiState: StateFlow<TrendingUiState> =
        _trendingUiState


    fun fetchTrendingList() {
        viewModelScope.launch {
            _trendingUiState.emit(TrendingUiState.Loading)
            fetchTrendingListUseCase().collect {
                when (it) {
                    is ResultState.Success -> {
                        _trendingUiState.emit(TrendingUiState.TrendingList(it.data))
                    }

                    else -> {}
                }
            }
        }
    }
}