package com.bignerdranch.android.footballcompetitions.data.local.repository

import com.bignerdranch.android.footballcompetitions.data.local.dao.CompetitionDAO
import com.bignerdranch.android.footballcompetitions.data.remote.model.team.Squad

class TeamRepository(private val competitionDAO: CompetitionDAO) {

    suspend fun saveTeam(id: Int, team: List<Squad>) {
        competitionDAO.saveTeam(team.map { it.toTeamEntity(id) })
    }

    suspend fun getTeam(id: Int): List<Squad> {
        return competitionDAO.getTeam(id).map { it.toTeam() }
    }
}