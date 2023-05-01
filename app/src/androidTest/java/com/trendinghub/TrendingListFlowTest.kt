package com.trendinghub

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import org.junit.Rule
import org.junit.Test

/* End to End test */
class TrendingListFlowTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    @Test
    fun validateIsTrendingListVisible() {
        composeTestRule.waitUntil(5000L) {
            composeTestRule
                .onAllNodesWithTag(composeTestRule.activity.getString(R.string.trending_list))
                .fetchSemanticsNodes().size == 1
        }
    }

}