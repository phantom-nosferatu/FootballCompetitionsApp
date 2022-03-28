package com.bignerdranch.android.footballcompetitions.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bignerdranch.android.footballcompetitions.data.remote.model.team.Squad

@Entity(tableName = "teams")
data class TeamEntity(
    @PrimaryKey
    val playerId: Int,
    val teamId: Int,
    val name: String,
    val position: String,
    val year: String
) {

    fun toTeam(): Squad = Squad(
        id = playerId,
        position = position,
        name = name,
        dateOfBirth = year
    )
}