package com.trendinghub.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.trendinghub.R
import com.trendinghub.domain.model.TrendingData

@Composable
fun TrendingRepositoryListView(
    trendingDataList: List<TrendingData>,
    onRefresh: () -> Unit
) {

    SwipeRefresh(
        onRefresh = onRefresh,
        state = SwipeRefreshState(false),
        modifier = Modifier.testTag(stringResource(id = R.string.swipe_to_refresh))
    ) {
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier
                .padding(top = 10.dp)
                .testTag(stringResource(id = R.string.trending_list))
        ) {
            trendingDataList.forEachIndexed { index, trendingData ->
                item {
                    TrendingRepositoryItemView(
                        trendingData = trendingData,
                        showDivider = trendingDataList.lastIndex != index
                    )
                }
            }
        }
    }
}