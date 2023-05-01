package com.trendinghub

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
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

    @Test
    fun validateSwipeToRefresh() {
        composeTestRule.waitUntilExists(
            hasTestTag(composeTestRule.activity.getString(R.string.trending_list)))

        // Perform swipe-to-refresh gesture
        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(R.string.trending_list)
        ).performTouchInput {
            swipeDown()
        }

        composeTestRule.waitUntilExists(
            hasTestTag(composeTestRule.activity.getString(R.string.loading)))

        composeTestRule.waitUntilExists(
            hasTestTag(composeTestRule.activity.getString(R.string.trending_list)))
    }

    companion object {
        fun ComposeContentTestRule.waitUntilExists(
            matcher: SemanticsMatcher,
            timeoutMillis: Long = 3000L
        ) {
            this.waitUntil(timeoutMillis) {
                this.onAllNodes(matcher).fetchSemanticsNodes().isNotEmpty()
            }
        }
    }
}