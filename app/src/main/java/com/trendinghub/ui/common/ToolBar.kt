package com.trendinghub.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ToolBar(text: String) {
    TopAppBar(
        title = {
            Text(
                text = text,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        },
        backgroundColor = MaterialTheme.colors.background
    )
}

@Preview
@Composable
private fun PreviewToolBar() {
    ToolBar("Trending")
}