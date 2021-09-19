package com.bignerdranch.android.footballcompetitions.model.competition

data class Competition(
    val area: Area,
    val code: Any,
    val currentSeason: CurrentSeason,
    val emblemUrl: Any,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val numberOfAvailableSeasons: Int,
    val plan: String
)