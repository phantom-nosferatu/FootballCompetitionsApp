package com.bignerdranch.android.footballcompetitions.data.remote.model.competition

import com.bignerdranch.android.footballcompetitions.data.local.entity.CompetitionEntity

data class Competition(
    val id: Int,
    val name: String,
) {

    fun toCompetitionEntity(): CompetitionEntity = CompetitionEntity(id = id, name = name)
}