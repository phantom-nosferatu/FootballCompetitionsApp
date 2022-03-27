package com.bignerdranch.android.footballcompetitions.data.remote.model.table

import com.bignerdranch.android.footballcompetitions.data.local.entity.TablesEntity

data class Table(
    val points: Int,
    val position: Int,
    val team: Team,
) {

    fun toTableEntity(id : Int) : TablesEntity = TablesEntity(
        teamId = team.id,
        compId = id,
        name = team.name,
        position = position,
        points = points,
        url = team.crestUrl
    )
}