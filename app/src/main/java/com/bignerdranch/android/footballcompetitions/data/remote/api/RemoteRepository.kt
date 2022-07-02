package com.bignerdranch.android.footballcompetitions.data.remote.api

import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.CompetitionResponse
import com.bignerdranch.android.footballcompetitions.data.remote.model.matches.MatchesResponse
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.TableResponse
import com.bignerdranch.android.footballcompetitions.data.remote.model.team.TeamResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RemoteRepository {

    suspend fun getCompetitions(): Response<CompetitionResponse> =
        withContext(Dispatchers.IO) { RetrofitInstance.api.getCompetitions() }

    suspend fun getTables(id: Int): Response<TableResponse> {
        return RetrofitInstance.api.getTables(id)
    }

    suspend fun getMatches(): Response<MatchesResponse> =
        withContext(Dispatchers.IO) { RetrofitInstance.api.getMatches() }

    suspend fun getTeam(id: Int): Response<TeamResponse> {
        return RetrofitInstance.api.getTeam(id)
    }

}
