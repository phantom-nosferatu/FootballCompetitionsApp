package com.bignerdranch.android.footballcompetitions.ui.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.footballcompetitions.data.local.repository.TeamRepository
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository


class TeamViewModelFactory(
    private val remoteRepository: RemoteRepository,
    private val teamRepository: TeamRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeamViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TeamViewModel(remoteRepository, teamRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}