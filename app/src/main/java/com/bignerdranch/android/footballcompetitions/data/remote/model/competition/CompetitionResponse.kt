package com.bignerdranch.android.footballcompetitions.data.remote.model.competition

data class CompetitionResponse(
    val competitions: List<Competition>,
    val count: Int,
    val filters: Filters
)