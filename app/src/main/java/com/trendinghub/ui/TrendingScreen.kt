package com.trendinghub.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.trendinghub.R
import com.trendinghub.ui.common.AnimatedShimmer
import com.trendinghub.ui.common.MockProvider
import com.trendinghub.ui.common.ToolBar

@Composable
fun TrendingScreen() {

    val trendingState = remember {
        mutableStateOf<TrendingUiState>(TrendingUiState.Error)
    }

    TrendingScreen(trendingUiState = trendingState.value) {
        trendingState.value = TrendingUiState.Loading
    }
}

@Composable
fun TrendingScreen(
    trendingUiState: TrendingUiState,
    onRetry: () -> Unit
) {

    Scaffold {
        it
        Column {

            ToolBar(stringResource(id = R.string.trending))

            when (trendingUiState) {
                is TrendingUiState.Loading -> {
                    repeat(7) {
                        AnimatedShimmer()
                    }
                }
                is TrendingUiState.TrendingList -> {
                    TrendingRepositoryListView(trendingDataList = trendingUiState.data)
                }

                is TrendingUiState.Error -> {
                    TrendingFailureView(onRetry = onRetry)
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun TrendingScreenLoadingPreview() {
    TrendingScreen(trendingUiState = TrendingUiState.Loading) {}
}

@Composable
@Preview(showSystemUi = true)
fun TrendingScreenListingPreview() {
    TrendingScreen(trendingUiState = TrendingUiState.TrendingList(listOf(MockProvider.getTrendingData()))) {}
}