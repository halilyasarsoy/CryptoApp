package com.halil.cryptoapp.base

import com.google.gson.Gson
import com.halil.cryptoapp.model.errorResponse.ErrorResponse
import com.halil.cryptoapp.util.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    suspend fun <T> safeApiRequest(
        apirequest: suspend () -> T
    ): NetworkResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                NetworkResult.Success(apirequest.invoke())
            } catch (throwble: Throwable) {
                when (throwble) {
                    is HttpException -> {
                        NetworkResult.Error(
                            false,
                            errorBudyParse(throwble.response()?.errorBody()?.string())
                        )
                    }
                    else -> NetworkResult.Error(true, throwble.localizedMessage)
                }
            }
        }
    }
}

private fun errorBudyParse(error: String?): String {
    error?.let {
        return try {
            val errorResponse = Gson().fromJson(error, ErrorResponse::class.java)
            val errorMessage = errorResponse.status?.errorMessage
            errorMessage ?: "Bilinmeyen bir hata oluştu."
        } catch (e: Exception) {
            "Bilinmeyen bir hata oluştu."
        }
    }
    return "Bilinmeyen bir hata oluştu."
}