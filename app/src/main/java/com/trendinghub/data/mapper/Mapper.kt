package com.trendinghub.data.mapper

import com.trendinghub.data.remote.source.model.Items
import com.trendinghub.domain.model.TrendingData

fun Items.toTrendingData() = TrendingData(
    userName = this.owner.login,
    userAvatar = this.owner.avatarUrl,
    repoName = this.name,
    stargazersCount = this.stargazersCount,
    language = this.language
)