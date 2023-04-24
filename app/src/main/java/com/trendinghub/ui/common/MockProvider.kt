package com.trendinghub.ui.common

import com.trendinghub.data.remote.source.model.Items
import com.trendinghub.data.remote.source.model.Owner
import com.trendinghub.data.remote.source.model.TrendingResponseData
import com.trendinghub.domain.model.TrendingData

object MockProvider {

    fun getTrendingData() = TrendingData(
        repoName = "TrendingHub",
        userAvatar = "https://avatars.githubusercontent.com/u/4314092?v=4",
        userName = "Maria",
        stargazersCount = 1000,
        language = "Kotlin"
    )

    fun getTrendingResponseData() = TrendingResponseData(
        items = arrayListOf(
            Items(
                id = 1,
                nodeId = "",
                name = "TrendingHub",
                fullName = "Maria/TrendingHub",
                owner = Owner(
                    login = "Maria",
                    avatarUrl = "https://avatars.githubusercontent.com/u/4314092?v=4"
                ),
                stargazersCount = 1000,
                language = "Kotlin",
                private = true
            )
        )
    )
}