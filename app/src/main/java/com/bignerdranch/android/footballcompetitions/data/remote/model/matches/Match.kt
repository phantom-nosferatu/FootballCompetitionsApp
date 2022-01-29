package com.bignerdranch.android.footballcompetitions.data.remote.model.matches

data class Match(
    val awayTeam: AwayTeam,
    val competition: Competition,
    val goals: List<Goal>,
    val group: String,
    val homeTeam: HomeTeam,
    val id: Int,
    val lastUpdated: String,
    val matchday: Int,
    val referees: List<Referee>,
    val score: Score,
    val season: Season,
    val stage: String,
    val status: String,
    val substitutions: List<Substitution>,
    val utcDate: String
)