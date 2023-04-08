package com.trendinghub.ui

import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.trendinghub.R
import com.trendinghub.domain.model.TrendingData
import com.trendinghub.ui.base.MainActivity

import org.junit.Test

import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TrendingListScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val trendingUiState = mutableStateOf<TrendingUiState>(TrendingUiState.Loading)

    @Before
    fun setup(){
        composeTestRule.activity.setContent {
            TrendingScreen(
                trendingUiState.value
            )
        }
    }

    @Test
    fun showTrendingList() {
        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(R.string.loading)
        ).assertIsDisplayed()

        trendingUiState.value = TrendingUiState.TrendingList(
            listOf(
                TrendingData(
                    repoName = "test",
                    imageUrl = "https://image.com",
                    userName = "maria"
                )
            )
        )

        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(R.string.trendingList)
        ).assertIsDisplayed()
        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(R.string.loading)
        ).assertIsNotDisplayed()
    }


    @Test
    fun showDataNotFound() {

    }
}