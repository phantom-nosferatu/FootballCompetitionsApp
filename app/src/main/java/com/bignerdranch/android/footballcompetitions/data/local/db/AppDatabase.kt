package com.bignerdranch.android.footballcompetitions.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bignerdranch.android.footballcompetitions.data.local.dao.CompetitionDAO
import com.bignerdranch.android.footballcompetitions.data.local.entity.CompetitionEntity

@Database(version = 1,
    entities = [CompetitionEntity::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun competitionDao() : CompetitionDAO
}