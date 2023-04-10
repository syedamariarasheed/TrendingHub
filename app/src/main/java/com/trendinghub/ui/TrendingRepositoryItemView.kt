package com.trendinghub.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.trendinghub.R
import com.trendinghub.domain.model.TrendingData
import com.trendinghub.ui.common.MockProvider

@Composable
fun TrendingRepositoryItemView(trendingData: TrendingData) {
    ConstraintLayout(
        modifier = Modifier.padding(10.dp)
    ) {
        val (avatar, username, repositoryName, language, starIcon, stargazersCount, divider) = createRefs()
        AsyncImage(
            model = trendingData.userAvatar,
            contentDescription = "user image",
            modifier = Modifier
                .size(80.dp)
                .constrainAs(avatar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
                .testTag(stringResource(id = R.string.user_avatar)),
            placeholder = rememberVectorPainter(image = Icons.Default.Person),
            error = rememberVectorPainter(image = Icons.Default.Person)
        )

        Text(
            text = trendingData.userName,
            modifier = Modifier
                .constrainAs(username) {
                    top.linkTo(parent.top)
                    start.linkTo(avatar.end)
                }
                .testTag(
                    stringResource(id = R.string.user_name)
                ),
        )
        Text(
            text = trendingData.repoName,
            modifier = Modifier
                .constrainAs(repositoryName) {
                    top.linkTo(username.bottom)
                    start.linkTo(avatar.end)
                }
                .testTag(stringResource(id = R.string.repository_name)),
            style = TextStyle(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        )

        Text(
            text = trendingData.language,
            modifier = Modifier
                .constrainAs(language) {
                    top.linkTo(repositoryName.bottom)
                    start.linkTo(avatar.end)
                }
                .testTag(stringResource(id = R.string.language))
        )
        Image(
            painter = rememberVectorPainter(image = Icons.Default.Star),
            colorFilter = ColorFilter.tint(Color.Magenta), contentDescription = "star",
            modifier = Modifier.constrainAs(starIcon) {
                top.linkTo(repositoryName.bottom)
                start.linkTo(language.end, 10.dp)
            }
        )
        Text(
            text = trendingData.stargazersCount.toString(),
            modifier = Modifier
                .constrainAs(stargazersCount) {
                    top.linkTo(repositoryName.bottom)
                    start.linkTo(starIcon.end, 10.dp)
                }
                .testTag(stringResource(id = R.string.stargazers_count))
        )
        Divider(
            color = Color.LightGray,
            modifier = Modifier
                .constrainAs(divider) {
                    top.linkTo(stargazersCount.bottom, 10.dp)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun PreviewTrendingRepositoryItemView() {
    TrendingRepositoryItemView(MockProvider.getTrendingData())
}