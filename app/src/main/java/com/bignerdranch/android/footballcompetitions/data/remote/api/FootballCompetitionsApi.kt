package com.bignerdranch.android.footballcompetitions.data.remote.api

import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.CompetitionResponse
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.TableResponse
import retrofit2.Response
import retrofit2.http.GET

interface FootballCompetitionsApi {

    @GET("v2/competitions")
    suspend fun getCompetitions() : Response<CompetitionResponse>

   @GET("/v2/competitions/{id}/standings")
   suspend fun getTables() : Response<TableResponse>
}