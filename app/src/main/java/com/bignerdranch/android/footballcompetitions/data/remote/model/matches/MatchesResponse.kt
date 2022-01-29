package com.bignerdranch.android.footballcompetitions.data.remote.model.matches

data class MatchesResponse(
    val count: Int,
    val filters: Filters,
    val matches: List<Match>
)