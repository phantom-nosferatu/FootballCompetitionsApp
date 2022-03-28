package com.bignerdranch.android.footballcompetitions.data.remote.model.team

import com.bignerdranch.android.footballcompetitions.data.local.entity.TeamEntity

data class Squad(
    val id : Int,
    val dateOfBirth: String,
    val name: String,
    val position: String,
) {

    fun toTeamEntity(_id : Int) : TeamEntity = TeamEntity(
        teamId = _id,
        playerId = id,
        name = name,
        position = position,
        year = dateOfBirth
    )
}