package com.trendinghub.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.trendinghub.R
import com.trendinghub.ui.common.AnimatedShimmer
import com.trendinghub.ui.common.MockProvider
import com.trendinghub.ui.common.ToolBar
import com.trendinghub.ui.common.theme.TrendingHubTheme
import com.trendinghub.ui.viewmodel.TrendingViewModel

@Composable
fun TrendingScreen(
    viewModel: TrendingViewModel = hiltViewModel(),
) {
    val trendingUiState = viewModel.trendingUiState.collectAsStateWithLifecycle()

    TrendingScreen(
        trendingUiState = trendingUiState.value,
        onRetry = viewModel::fetchTrendingList
    )
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
                    TrendingFailureView(onRetry = onRetry, trendingUiState.message)
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun TrendingScreenLoadingPreview() {
    TrendingScreen(trendingUiState = TrendingUiState.Loading, onRetry = {})
}

@Composable
@Preview(showSystemUi = true)
fun TrendingScreenListingPreview() {
    TrendingScreen(
        trendingUiState = TrendingUiState.TrendingList(
            listOf(
                MockProvider.getTrendingData(),
                MockProvider.getTrendingData(),
                MockProvider.getTrendingData()
            )
        ),
        onRetry = {}
    )
}

@Composable
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
fun TrendingScreenListingPreviewDark() {
    TrendingHubTheme {
        Surface {
            TrendingScreen(
                trendingUiState = TrendingUiState.TrendingList(
                    listOf(
                        MockProvider.getTrendingData(),
                        MockProvider.getTrendingData(),
                        MockProvider.getTrendingData()
                    )
                ),
                onRetry = {}
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun TrendingScreenErrorPreview() {
    TrendingScreen(trendingUiState = TrendingUiState.Error("An alien is blocking your signal"), onRetry = {})
}