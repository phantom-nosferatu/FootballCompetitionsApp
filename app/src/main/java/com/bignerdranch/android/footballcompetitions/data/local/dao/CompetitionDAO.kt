package com.bignerdranch.android.footballcompetitions.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bignerdranch.android.footballcompetitions.data.local.entity.CompetitionEntity


@Dao
interface CompetitionDAO {

    @Query("SELECT * FROM competitions")
    suspend fun getAllCompetitions() : List<CompetitionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCompetitions(competition : List<CompetitionEntity>)
}