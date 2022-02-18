package com.bignerdranch.android.footballcompetitions.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class MatchesEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val homeTeamName: String,
    val awayTeamName: String,
    val homeTeamScore: Int,
    val awayTeamScore: Int,
    val date: String
)