package com.bignerdranch.android.footballcompetitions.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.Competition

@Entity(tableName = "competitions")
data class CompetitionEntity(@PrimaryKey(autoGenerate = false) val id: Int, val name: String) {

    fun toCompetition() : Competition = Competition(id = id, name = name)
}