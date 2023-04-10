package com.trendinghub.ui.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ToolBar(text: String) {
    TopAppBar(
        title = {
            Text(
                text = text
            )
        },
        backgroundColor = Color.White
    )
}

@Preview(name = "ToolBar")
@Composable
private fun PreviewToolBar() {
    ToolBar("Trending")
}