package com.trendinghub.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.trendinghub.R
import com.trendinghub.domain.model.TrendingData

@Composable
fun TrendingRepositoryListView(
    trendingDataList: List<TrendingData>
) {
    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier
            .padding(top = 10.dp)
            .testTag(stringResource(id = R.string.trending_list))
    ) {
        trendingDataList.forEach { trendingData ->
            item {
                TrendingRepositoryItemView(trendingData = trendingData)
            }
        }
    }
}