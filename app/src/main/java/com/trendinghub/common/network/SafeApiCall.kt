package com.trendinghub.common.network

import com.trendinghub.common.Constants
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResultState<T> {
    return try {
        val response = apiCall.invoke()
        ResultState.Success(response)
    } catch (throwable: Throwable) {
        when (throwable) {
            is IOException -> ResultState.Error(Constants.NETWORK_CONNECTIVITY_ERROR_MESSAGE)
            is HttpException -> ResultState.Error(
                Constants.HTTP_ERROR_MESSAGE
            )
            else -> ResultState.Error(Constants.UNKNOWN_ERROR_MESSAGE)
        }
    }
}