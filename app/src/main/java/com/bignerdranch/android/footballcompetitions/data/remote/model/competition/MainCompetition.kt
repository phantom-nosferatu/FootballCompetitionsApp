package com.bignerdranch.android.footballcompetitions.data.remote.model.competition

data class MainCompetition(
    val competitions: List<Competition>,
    val count: Int,
    val filters: Filters
)