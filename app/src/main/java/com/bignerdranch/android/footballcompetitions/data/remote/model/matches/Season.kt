package com.bignerdranch.android.footballcompetitions.data.remote.model.matches

data class Season(
    val availableStages: List<String>,
    val currentMatchday: Int,
    val endDate: String,
    val id: Int,
    val startDate: String
)