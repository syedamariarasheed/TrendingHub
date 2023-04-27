package com.trendinghub.data.remote.source.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrendingResponseData(
    @Json(name = "total_count")
    var totalCount: Int,
    @Json(name = "incomplete_results")
    var incompleteResults: Boolean,
    @Json(name = "items")
    var items: List<Items>
)