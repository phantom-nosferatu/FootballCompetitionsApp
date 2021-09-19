package com.bignerdranch.android.footballcompetitions.model.competition

data class MainCompetition(
    val competitions: List<Competition>,
    val count: Int,
    val filters: Filters
)