package com.trendinghub.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun TrendingScreen(
    trendingUiState: TrendingUiState
) {
    Scaffold {
        it

        Column {

            when (trendingUiState) {
                is TrendingUiState.Loading -> {

                }
                is TrendingUiState.TrendingList -> {

                }
                else -> {}
            }
        }
    }
}