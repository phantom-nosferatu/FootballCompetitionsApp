package com.bignerdranch.android.footballcompetitions.data.local.repository

import com.bignerdranch.android.footballcompetitions.data.local.dao.CompetitionDAO
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.Table

class TableRepository(private val competitionDAO: CompetitionDAO) {

    suspend fun saveTable(id : Int, table: List<Table>) {
        competitionDAO.saveTables(table.map { it.toTableEntity(id) })
    }

    suspend fun getTables(id : Int): List<Table> {
        return competitionDAO.getTables(id).map { it.toTable() }
    }

}