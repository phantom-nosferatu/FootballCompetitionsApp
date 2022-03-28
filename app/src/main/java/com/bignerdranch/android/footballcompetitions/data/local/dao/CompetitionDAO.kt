package com.bignerdranch.android.footballcompetitions.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bignerdranch.android.footballcompetitions.data.local.entity.CompetitionEntity
import com.bignerdranch.android.footballcompetitions.data.local.entity.MatchesEntity
import com.bignerdranch.android.footballcompetitions.data.local.entity.TablesEntity
import com.bignerdranch.android.footballcompetitions.data.local.entity.TeamEntity


@Dao
interface CompetitionDAO {

    // Competitions

    @Query("SELECT * FROM competitions")
    suspend fun getAllCompetitions(): List<CompetitionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCompetitions(competition: List<CompetitionEntity>)

    // Matches

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMatches(match: List<MatchesEntity>)

    @Query("SELECT * FROM matches")
    suspend fun getMatches() : List<MatchesEntity>

    // Tables

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTables(table : List<TablesEntity>)

    @Query("SELECT * FROM tables WHERE compId LIKE :id ORDER BY position ASC")
    suspend fun getTables(id : Int) : List<TablesEntity>

    // Teams
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTeam(team : List<TeamEntity>)

    @Query("SELECT * FROM teams WHERE teamId LIKE :id ")
    suspend fun getTeam(id : Int) : List<TeamEntity>
}