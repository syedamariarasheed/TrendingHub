package com.trendinghub.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.trendinghub.R
import com.trendinghub.domain.model.TrendingData
import com.trendinghub.ui.common.MockProvider

@Composable
fun TrendingRepositoryItemView(trendingData: TrendingData) {
    ConstraintLayout {
        val (layout, button) = createRefs()
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
            Text(
                text = trendingData.repoName,
                modifier = Modifier.testTag(stringResource(id = R.string.repository_name))
            )
            Row {
                Text(
                    text = trendingData.language,
                    modifier = Modifier.testTag(stringResource(id = R.string.language))
                )
                Text(
                    text = trendingData.stargazersCount.toString(),
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

@Preview(name = "TrendingRepositoryItemView")
@Composable
private fun PreviewTrendingRepositoryItemView() {
    TrendingRepositoryItemView(MockProvider.getTrendingData())
}