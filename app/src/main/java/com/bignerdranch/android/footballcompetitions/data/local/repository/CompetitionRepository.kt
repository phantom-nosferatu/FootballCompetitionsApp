package com.bignerdranch.android.footballcompetitions.data.local.repository

import com.bignerdranch.android.footballcompetitions.data.local.dao.CompetitionDAO
import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.Competition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CompetitionRepository(private val competitionDAO: CompetitionDAO) {

    suspend fun saveCompetition(competition: List<Competition>) =
        withContext(Dispatchers.IO) {
            competitionDAO.saveCompetitions(competition.map { it.toCompetitionEntity() })
        }

    suspend fun getAllCompetition(): List<Competition> =
        withContext(Dispatchers.IO) {
            competitionDAO.getAllCompetitions().map { it.toCompetition() }
        }
}