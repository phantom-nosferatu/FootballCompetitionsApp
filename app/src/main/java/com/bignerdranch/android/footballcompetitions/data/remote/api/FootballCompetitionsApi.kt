package com.bignerdranch.android.footballcompetitions.data.remote.api

import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.CompetitionResponse
import com.bignerdranch.android.footballcompetitions.data.remote.model.matches.MatchesResponse
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.TableResponse
import com.bignerdranch.android.footballcompetitions.data.remote.model.team.TeamResponse
import com.bignerdranch.android.footballcompetitions.utils.Constants.Companion.API_TOKEN
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface FootballCompetitionsApi {


    @Headers("X-Auth-Token: $API_TOKEN")
    @GET("v2/competitions")
    suspend fun getCompetitions(): Response<CompetitionResponse>

    @Headers("X-Auth-Token: $API_TOKEN")
    @GET("v2/competitions/{id}/standings")
    suspend fun getTables(@Path("id") id: Int): Response<TableResponse>

    @Headers("X-Auth-Token: $API_TOKEN")
    @GET("/v2/matches")
    suspend fun getMatches(): Response<MatchesResponse>

    @Headers("X-Auth-Token: $API_TOKEN")
    @GET("/v2/teams/{id}")
    suspend fun getTeam(@Path("id") id: Int) : Response<TeamResponse>


}