package com.bignerdranch.android.footballcompetitions.data.local.repository

import com.bignerdranch.android.footballcompetitions.data.local.dao.CompetitionDAO
import com.bignerdranch.android.footballcompetitions.data.local.entity.MatchesEntity
import com.bignerdranch.android.footballcompetitions.data.remote.model.matches.*

class MatchRepository(private val competitionDAO: CompetitionDAO) {

    suspend fun saveMatches(match: List<Match>) {
        competitionDAO.saveMatches(match.map {
            MatchesEntity(
                id = 0,
                homeTeamName = it.homeTeam.name,
                awayTeamName = it.awayTeam.name,
                homeTeamScore = it.score.fullTime.homeTeam,
                awayTeamScore = it.score.fullTime.awayTeam,
                date = it.utcDate
            )
        })
    }

    suspend fun getMatches(): List<Match> {
        return competitionDAO.getMatches().map {
            Match(
                AwayTeam(name = it.awayTeamName),
                HomeTeam(name = it.homeTeamName),
                Score(FullTime(awayTeam = it.awayTeamScore, homeTeam = it.homeTeamScore)),
                utcDate = it.date
            )
        }
    }
}