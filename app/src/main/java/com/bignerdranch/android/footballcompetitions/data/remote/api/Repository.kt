package com.bignerdranch.android.footballcompetitions.data.remote.api

import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.CompetitionResponse
import retrofit2.Response

class Repository {

    suspend fun getCompetitions() : Response<CompetitionResponse> {
        return RetrofitInstance.api.getCompetitions()
    }
}
