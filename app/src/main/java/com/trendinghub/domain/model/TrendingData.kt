package com.trendinghub.domain.model

data class TrendingData(
    val userName: String,
    val userAvatar: String,
    val repoName: String,
    val stargazersCount: Long,
    val language: String
)
