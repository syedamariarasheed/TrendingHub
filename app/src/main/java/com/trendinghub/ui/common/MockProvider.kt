package com.trendinghub.ui.common

import com.trendinghub.domain.model.TrendingData

object MockProvider {

    fun getTrendingData() = TrendingData(
        repoName = "TrendingHub",
        userAvatar = "https://avatars.githubusercontent.com/u/4314092?v=4",
        userName = "Maria",
        stargazersCount = 1000,
        language = "Kotlin"
    )

}