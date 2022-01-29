package com.bignerdranch.android.footballcompetitions.data.remote.model.matches

data class Score(
    val duration: String,
    val fullTime: FullTime,
    val penalties: Penalties,
)