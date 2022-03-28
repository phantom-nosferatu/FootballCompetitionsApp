package com.bignerdranch.android.footballcompetitions

import android.app.Application
import com.bignerdranch.android.footballcompetitions.data.local.db.AppDatabase
import com.bignerdranch.android.footballcompetitions.data.local.repository.CompetitionRepository
import com.bignerdranch.android.footballcompetitions.data.local.repository.MatchRepository
import com.bignerdranch.android.footballcompetitions.data.local.repository.TableRepository
import com.bignerdranch.android.footballcompetitions.data.local.repository.TeamRepository

class App : Application() {

    val matchRepository by lazy { MatchRepository(AppDatabase.getInstance(this).competitionDao()) }
    val competitionRepository by lazy {
        CompetitionRepository(
            AppDatabase.getInstance(this).competitionDao()
        )
    }

    val tableRepository by lazy {
        TableRepository(AppDatabase.getInstance(this).competitionDao())
    }

    val teamRepository by lazy {
        TeamRepository(AppDatabase.getInstance(this).competitionDao())
    }

    override fun onCreate() {
        super.onCreate()
        val database = AppDatabase.getInstance(this)
    }
}