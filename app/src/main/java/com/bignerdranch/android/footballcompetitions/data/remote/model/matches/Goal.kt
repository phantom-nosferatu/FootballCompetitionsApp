package com.bignerdranch.android.footballcompetitions.data.remote.model.matches

data class Goal(
    val minute: Int,
    val scorer: Scorer,
    val team: TeamX,
    val type: String
)