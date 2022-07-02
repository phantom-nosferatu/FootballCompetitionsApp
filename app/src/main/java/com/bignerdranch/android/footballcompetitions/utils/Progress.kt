package com.bignerdranch.android.footballcompetitions.utils

import java.lang.Exception

sealed class Progress<T>

class PendingProgress<T> : Progress<T>()
class ErrorProgress<T>(val exception: Exception) : Progress<T>()
class SuccessProgress<T>(val data : T) : Progress<T>()


