package com.bignerdranch.android.footballcompetitions.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bignerdranch.android.footballcompetitions.data.local.dao.CompetitionDAO
import com.bignerdranch.android.footballcompetitions.data.local.entity.CompetitionEntity
import com.bignerdranch.android.footballcompetitions.data.local.entity.MatchesEntity
import com.bignerdranch.android.footballcompetitions.data.local.entity.TablesEntity

@Database(
    version = 1,
    entities = [CompetitionEntity::class, MatchesEntity::class, TablesEntity::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun competitionDao(): CompetitionDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context : Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "competition_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
