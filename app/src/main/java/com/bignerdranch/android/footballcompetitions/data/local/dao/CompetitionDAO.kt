package com.bignerdranch.android.footballcompetitions.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bignerdranch.android.footballcompetitions.data.local.entity.CompetitionEntity
import com.bignerdranch.android.footballcompetitions.data.local.entity.MatchesEntity


@Dao
interface CompetitionDAO {

    // Competitions

    @Query("SELECT * FROM competitions")
    suspend fun getAllCompetitions(): List<CompetitionEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveCompetitions(competition: List<CompetitionEntity>)

    // Matches

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveMatches(match: List<MatchesEntity>)

    @Query("SELECT * FROM matches")
    suspend fun getMatches() : List<MatchesEntity>
}