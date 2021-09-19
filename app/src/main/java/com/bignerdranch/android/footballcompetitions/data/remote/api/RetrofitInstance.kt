package com.bignerdranch.android.footballcompetitions.api

import com.bignerdranch.android.footballcompetitions.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:FootballCompetitionsApi by lazy {
        retrofit.create(FootballCompetitionsApi::class.java)
    }
}