package com.trendinghub.ui.base

import com.trendinghub.domain.model.TrendingData

object MockProvider {

    fun getTrendingData() = TrendingData(
        repoName = "test",
        userAvatar = "https://avatars.githubusercontent.com/u/4314092?v=4",
        userName = "maria",
        stargazersCount = 3000,
        language = "java"
    )

}