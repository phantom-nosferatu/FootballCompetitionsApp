package com.bignerdranch.android.footballcompetitions.data.local.repository

import com.bignerdranch.android.footballcompetitions.data.local.dao.CompetitionDAO
import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.Competition

class CompetitionRepository(private val competitionDAO: CompetitionDAO) {

    suspend fun saveCompetition(competition : List<Competition>) {
        competitionDAO.saveCompetitions(competition.map {it.toCompetitionEntity()})
    }
}