package com.bignerdranch.android.footballcompetitions.data.remote.model.matches

data class Match(
    val awayTeam: AwayTeam,
    val homeTeam: HomeTeam,
    val score: Score,
    val utcDate: String
)