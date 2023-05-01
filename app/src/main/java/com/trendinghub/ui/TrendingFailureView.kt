package com.trendinghub.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.trendinghub.R
import com.trendinghub.ui.common.theme.Green
import com.trendinghub.ui.common.theme.TrendingHubTheme

@Composable
fun TrendingFailureView(onRetry: () -> Unit, message: String) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.retry)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag(
                stringResource(id = R.string.data_not_found)
            ),
        verticalArrangement = Arrangement.Center
    ) {

        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier
                .fillMaxWidth()
                .weight(weight = 0.5f)
        )

        Text(
            text = stringResource(R.string.error_message),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ),
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .weight(0.08f),
            textAlign = TextAlign.Center

        )

        Text(
            text = message,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.08f)
                .testTag(stringResource(R.string.error_description)),
            textAlign = TextAlign.Center
        )

        Button(
            colors = ButtonDefaults
                .outlinedButtonColors(MaterialTheme.colors.background),
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
            border = BorderStroke(2.dp, Green),
            onClick = {
                onRetry.invoke()
            }
        ) {
            Text(
                text = stringResource(id = R.string.retry),
                color = Green,
            )
        }
    }
}

@Composable
@Preview(
    name = "TrendingFailureView",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
fun PreviewTrendingFailureViewDark() {
    TrendingHubTheme {
        Surface {
            TrendingFailureView(onRetry = {}, "An alien is blocking your signal")
        }
    }
}

@Composable
@Preview(
    name = "TrendingFailureView",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
fun PreviewTrendingFailureViewLight() {
    TrendingHubTheme {
        Surface {
            TrendingFailureView(onRetry = {}, "An alien is blocking your signal")
        }
    }
}
