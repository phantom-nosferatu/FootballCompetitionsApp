package com.bignerdranch.android.footballcompetitions.api

import com.bignerdranch.android.footballcompetitions.model.competition.Competition
import com.bignerdranch.android.footballcompetitions.model.competition.MainCompetition
import retrofit2.Response
import retrofit2.http.GET

interface FootballCompetitionsApi {

    @GET("v2/competitions")
    suspend fun getCompetitions() : Response<MainCompetition>
}