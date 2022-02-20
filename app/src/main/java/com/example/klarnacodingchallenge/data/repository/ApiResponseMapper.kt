package com.example.klarnacodingchallenge.data.repository

import com.example.klarnacodingchallenge.domain.DataHolder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

/**
 * Abstract class to give capabilities to child class of Encapsulating and handle checks for data
 * returned from API call.
 */
abstract class ApiResponseMapper {
    fun <T> safeApiCall(apiCall: () -> Flow<Response<T>>): Flow<DataHolder<T>> {
        return apiCall().map {
            try {
                if (it.isSuccessful) {
                    val body = it.body()
                    body?.let {
                        DataHolder.Success(body)
                    }
                }
                error("${it.code()} ${it.message()}")
            } catch (e: Exception) {
                error(e.message ?: e.toString())
            }
        }
    }

    /**
     * Set error
     */
    private fun <T> error(errorMessage: String): DataHolder<T> =
        DataHolder.Fail("Api call failed $errorMessage")
}