package com.bignerdranch.android.footballcompetitions.utils

import java.lang.Exception

typealias Mapper<Input, Output> = (Input) -> Output

sealed class Progress<T> {

    fun <R> map(mapper: Mapper<T, R>? = null): Progress<R> =
        when (this) {
            is PendingProgress -> PendingProgress()
            is ErrorProgress -> ErrorProgress(this.exception)
            is SuccessProgress -> {
                if (mapper == null) throw IllegalArgumentException("mapper null")
                SuccessProgress(mapper(this.data))
            }
        }
}

class PendingProgress<T> : Progress<T>()
class ErrorProgress<T>(val exception: Exception) : Progress<T>()
class SuccessProgress<T>(val data: T) : Progress<T>()

fun <T> Progress<T>.takeSuccess(): T? {
    return if (this is SuccessProgress)
        this.data
    else null
}