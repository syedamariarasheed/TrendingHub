package com.trendinghub.data.remote.source.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class License(
    @Json(name = "key")
    var key: String? = null,
    @Json(name = "name")
    var name: String? = null,
    @Json(name = "spdx_id")
    var spdxId: String? = null,
    @Json(name = "url")
    var url: String? = null,
    @Json(name = "node_id")
    var nodeId: String? = null
)
