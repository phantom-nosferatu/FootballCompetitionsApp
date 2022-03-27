package com.bignerdranch.android.footballcompetitions.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.Table
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.Team

@Entity(tableName = "tables")
data class TablesEntity(
    @PrimaryKey
    val teamId: Int,
    val compId : Int,
    val name: String,
    val position: Int,
    val points: Int,
    val url: String
) {
    fun toTable() : Table = Table(
        points = points,
        position = position,
        Team(name = name, crestUrl = url, id = teamId)
    )
}