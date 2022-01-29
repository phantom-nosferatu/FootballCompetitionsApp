package com.bignerdranch.android.footballcompetitions.data.remote.model.matches

data class Substitution(
    val minute: Int,
    val playerIn: PlayerIn,
    val playerOut: PlayerOut,
    val team: TeamXX
)