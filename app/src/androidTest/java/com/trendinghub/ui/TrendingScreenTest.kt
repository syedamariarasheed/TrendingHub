package com.trendinghub.ui

import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.trendinghub.MainActivity
import com.trendinghub.R
import com.trendinghub.common.Constants
import com.trendinghub.ui.common.MockProvider.getTrendingData
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TrendingScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val trendingUiState = mutableStateOf<TrendingUiState>(TrendingUiState.Loading)

    @Before
    fun setup() {
        composeTestRule.activity.setContent {
            TrendingScreen(
                trendingUiState.value,
                onRetry = { trendingUiState.value = TrendingUiState.Loading }
            )
        }
    }

    @Test
    fun showTrendingList() {
        composeTestRule.onAllNodesWithTag(
            composeTestRule.activity.getString(R.string.loading)
        ).onFirst().assertIsDisplayed()

        trendingUiState.value = TrendingUiState.TrendingList(listOf(getTrendingData()))

        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(R.string.trending_list)
        ).assertIsDisplayed()

        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(
                R.string.user_name
            )
        ).assertIsDisplayed()
        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(
                R.string.repository_name
            )
        ).assertIsDisplayed()
        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(
                R.string.language
            )
        ).assertIsDisplayed()
        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(
                R.string.stargazers_count
            )
        ).assertIsDisplayed()
        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(
                R.string.user_avatar
            )
        ).assertIsDisplayed()
        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(R.string.loading)
        ).assertDoesNotExist()
    }


    @Test
    fun showTrendingListError()  {
        composeTestRule.onAllNodesWithTag(
            composeTestRule.activity.getString(R.string.loading)
        ).onFirst().assertIsDisplayed()

        trendingUiState.value = TrendingUiState.Error(Constants.UNKNOWN_ERROR_MESSAGE)

        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(R.string.data_not_found)
        ).assertIsDisplayed()
        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(R.string.error_description)
        ).assertTextEquals("Unknown error")

        // retry - assert loading
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.retry))
            .performClick()

        composeTestRule.onAllNodesWithTag(
            composeTestRule.activity.getString(R.string.loading)
        ).onFirst().assertIsDisplayed()

    }
}