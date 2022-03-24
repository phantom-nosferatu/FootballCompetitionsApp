package com.bignerdranch.android.footballcompetitions.data.local.repository

import com.bignerdranch.android.footballcompetitions.data.local.dao.CompetitionDAO
import com.bignerdranch.android.footballcompetitions.data.local.entity.TablesEntity
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.Table
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.Team

class TableRepository(private val competitionDAO: CompetitionDAO) {

    suspend fun saveTable(_id : Int, table: List<Table>) {
        competitionDAO.saveTables(table.map {
            TablesEntity(
                id = _id,
                teamId = it.team.id,
                name = it.team.name,
                position = it.position,
                points = it.points,
                url = it.team.crestUrl
            )
        })
    }

    suspend fun getTables(): List<Table> {
        return competitionDAO.getTables().map {
            Table(
                points = it.points,
                position = it.position,
                Team(name = it.name, crestUrl = it.url, id = it.teamId)
            )
        }
    }
}