package com.bignerdranch.android.footballcompetitions.data.local.entity

import androidx.room.Entity
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.Table
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.Team

@Entity(tableName = "tables")
data class TablesEntity(
    val id: Int,
    val teamId: Int,
    val name: String,
    val position: Int,
    val points: Int,
    val url: String
)