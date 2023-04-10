package com.trendinghub.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.trendinghub.R

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
                    LazyColumn(
                        state = rememberLazyListState(),
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .testTag(stringResource(id = R.string.trending_list))
                    ) {
                        trendingUiState.data.forEach { trendingData ->
                            item {
                                Row {
                                    AsyncImage(
                                        model = trendingData.userAvatar,
                                        contentDescription = "user image",
                                        modifier = Modifier.testTag(stringResource(id = R.string.user_avatar)),
                                        placeholder = rememberVectorPainter(image = Icons.Default.Person),
                                        error = rememberVectorPainter(image = Icons.Default.Person)
                                    )
                                    Column {
                                        Text(
                                            text = trendingData.userName,
                                            modifier = Modifier.testTag(
                                                stringResource(id = R.string.user_name)
                                            )
                                        )
                                        Text(text = trendingData.repoName,
                                            modifier = Modifier.testTag(stringResource(id = R.string.repository_name))
                                        )
                                        Row {
                                            Text(text = trendingData.language,
                                                modifier = Modifier.testTag(stringResource(id = R.string.language))
                                            )
                                            Text(text = trendingData.stargazersCount.toString(),
                                                modifier = Modifier.testTag(stringResource(id = R.string.stargazers_count))
                                            )
                                        }
                                    }
                                }
                                Divider(
                                    color = Color.LightGray,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )
                            }
                        }
                    }
                }
                else -> {}
            }
        }
    }
}