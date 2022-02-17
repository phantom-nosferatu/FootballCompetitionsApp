package com.bignerdranch.android.footballcompetitions.data.local.entity


data class MatchesEntity(
    val homeTeamName: String,
    val awayTeamName: String,
    val homeTeamScore: Int,
    val awayTeamScore: Int,
    val date: String
)