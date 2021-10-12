package com.bignerdranch.android.footballcompetitions.data.remote.model.table

import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.Competition

data class TableResponse(
    val competition: Competition,
    val standings: List<Standing>
)