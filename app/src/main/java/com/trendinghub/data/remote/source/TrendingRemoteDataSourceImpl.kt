package com.trendinghub.data.remote.source

import com.trendinghub.common.ResultState
import com.trendinghub.data.remote.ApiService
import com.trendinghub.data.remote.source.model.TrendingResponseData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class TrendingRemoteDataSourceImpl(
    private val apiService: ApiService
) : TrendingRemoteDataSource {
    override fun fetchTrendingList(): Flow<ResultState<TrendingResponseData>> = flow {
        emit(
            safeApiCall {
                apiService.fetchTrendingList()
            }
        )
    }
}

suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResultState<T> {
    return try {
        val response = apiCall.invoke()
        ResultState.Success(response)
    } catch (throwable: Throwable) {
        when (throwable) {
            is IOException -> ResultState.Error("Check your network connectivity")
            is HttpException -> ResultState.Error(
               "An alien is probably blocking your signal"
            )
            else -> ResultState.Error("Unknown error")
        }
    }
}
