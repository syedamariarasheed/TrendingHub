package com.trendinghub.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trendinghub.common.network.ResultState
import com.trendinghub.common.collectEmission
import com.trendinghub.domain.usecase.FetchTrendingListUseCase
import com.trendinghub.ui.TrendingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject
constructor(val fetchTrendingListUseCase: FetchTrendingListUseCase) : ViewModel() {

    private val _trendingUiState =
        MutableStateFlow<TrendingUiState>(TrendingUiState.Loading)
    val trendingUiState: StateFlow<TrendingUiState> =
        _trendingUiState

    init {
        fetchTrendingList()
    }

    fun fetchTrendingList() = fetchTrendingListUseCase().collectEmission(
        map = {
            when (it) {
                is ResultState.Success -> {
                    TrendingUiState.TrendingList(it.data)
                }

                is ResultState.Error -> {
                    TrendingUiState.Error(it.message)
                }
            }
        },
        initialValue = TrendingUiState.Loading,
        uiStateFlow = _trendingUiState,
        scope = viewModelScope
    )
}