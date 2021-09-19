package com.bignerdranch.android.footballcompetitions.data.remote.api

import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.MainCompetition
import retrofit2.Response

class Repository {

    suspend fun getCompetitions() : Response<MainCompetition> {
        return RetrofitInstance.api.getCompetitions()
    }
}
