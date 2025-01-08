package com.trendinghub

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

/* End to End test */
class TrendingListFlowTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    @Test
    fun validateIsTrendingListVisible() {
        composeTestRule.waitUntilExists(
            composeTestRule.activity.getString(R.string.trending_list)
        )

        // assert lazyColumn item count
        val itemCount = composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.trending_list))
            .onChildren()
            .fetchSemanticsNodes()
            .size

        assertTrue(itemCount > 0)
    }

    @Test
    fun validateSwipeToRefresh() {
        composeTestRule.waitUntilExists(
            composeTestRule.activity.getString(R.string.trending_list)
        )

        // Perform swipe-to-refresh gesture
        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(R.string.trending_list)
        ).performTouchInput {
            swipeDown()
        }

        composeTestRule.waitUntilExists(
            composeTestRule.activity.getString(R.string.loading)
        )

        composeTestRule.waitUntilExists(
            composeTestRule.activity.getString(R.string.trending_list)
        )
    }

    companion object {
        fun ComposeContentTestRule.waitUntilExists(
            tag: String,
            timeoutMillis: Long = 3000L
        ) {
            this.waitUntil(timeoutMillis) {
                this.onAllNodesWithTag(tag).fetchSemanticsNodes().isNotEmpty()
            }
        }
    }
}