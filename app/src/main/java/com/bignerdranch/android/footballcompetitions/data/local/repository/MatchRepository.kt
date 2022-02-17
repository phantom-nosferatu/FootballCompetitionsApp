package com.bignerdranch.android.footballcompetitions.data.local.repository

import com.bignerdranch.android.footballcompetitions.data.local.dao.CompetitionDAO
import com.bignerdranch.android.footballcompetitions.data.local.entity.MatchesEntity
import com.bignerdranch.android.footballcompetitions.data.remote.model.matches.Match

class MatchRepository(private val competitionDAO: CompetitionDAO) {

    suspend fun saveMatches(match: List<Match>) {
        competitionDAO.saveMatches(match.map {
            MatchesEntity(
                homeTeamName = it.homeTeam.name,
                awayTeamName = it.awayTeam.name,
                homeTeamScore = it.score.fullTime.homeTeam,
                awayTeamScore = it.score.fullTime.awayTeam,
                date = it.utcDate
            )
        })
    }
}