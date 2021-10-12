package com.bignerdranch.android.footballcompetitions.data.remote.api

import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.CompetitionResponse
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.TableResponse
import retrofit2.Response

class Repository {

    suspend fun getCompetitions() : Response<CompetitionResponse> {
        return RetrofitInstance.api.getCompetitions()
    }

    suspend fun getTables(id : Int) : Response<TableResponse> {
        return RetrofitInstance.api.getTables(id)
    }
}
