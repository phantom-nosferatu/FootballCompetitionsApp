package com.bignerdranch.android.footballcompetitions.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bignerdranch.android.footballcompetitions.data.local.dao.CompetitionDAO
import com.bignerdranch.android.footballcompetitions.data.local.entity.CompetitionEntity

@Database(version = 1,
    entities = [CompetitionEntity::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun competitionDao() : CompetitionDAO

    companion object {
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "db_competitions")
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}