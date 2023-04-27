package com.trendinghub.data.remote

import com.trendinghub.data.remote.source.model.TrendingResponseData
import retrofit2.http.GET

interface ApiService {

    @GET("search/repositories?q=language=+sort:stars")
    suspend fun fetchTrendingList(): TrendingResponseData

}
