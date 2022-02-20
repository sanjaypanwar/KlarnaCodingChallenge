package com.example.klarnacodingchallenge.domain

/**
 * Sealed class to store the data from network layer, to handle Success and Failure instances.
 */
sealed class DataHolder<out T> {
    /**
     * Data holder in case of the network success
     */
    data class Success<T>(val data: T) : DataHolder<T>()

    /**
     * Data holder in case of the network success
     */
    data class Loading<T>(val data: T?) : DataHolder<T>()

    /**
     * Data holder in case of network failure
     */
    data class Fail<T>(val error: String? = null, val data: T? = null) : DataHolder<T>()
}