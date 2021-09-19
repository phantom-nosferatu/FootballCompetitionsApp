package com.bignerdranch.android.footballcompetitions.api

import com.bignerdranch.android.footballcompetitions.model.competition.Competition
import com.bignerdranch.android.footballcompetitions.model.competition.MainCompetition
import retrofit2.Response

class Repository {

    suspend fun getCompetitions() : Response<MainCompetition> {
        return RetrofitInstance.api.getCompetitions()
    }
}
