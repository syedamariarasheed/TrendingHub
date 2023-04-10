package com.trendinghub.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.trendinghub.ui.common.AnimatedShimmer

@Composable
fun TrendingScreen(
    trendingUiState: TrendingUiState
) {
    Scaffold {
        it
        Column {

            when (trendingUiState) {
                is TrendingUiState.Loading -> {
                    repeat(7) {
                        AnimatedShimmer()
                    }
                }
                is TrendingUiState.TrendingList -> {
                    TrendingRepositoryListView(trendingDataList = trendingUiState.data)
                }
                else -> {}
            }
        }
    }
}