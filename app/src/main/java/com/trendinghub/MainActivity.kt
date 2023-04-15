package com.trendinghub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.trendinghub.ui.TrendingScreen
import com.trendinghub.ui.common.theme.TrendingHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrendingHubTheme {
                Surface {
                    TrendingScreen()
                }
            }
        }
    }
}