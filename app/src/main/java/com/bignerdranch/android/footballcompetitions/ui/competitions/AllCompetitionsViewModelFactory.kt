package com.bignerdranch.android.footballcompetitions.ui.competitions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.footballcompetitions.data.local.repository.CompetitionRepository
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository


class AllCompetitionsViewModelFactory(private val remoteRepository: RemoteRepository, private val competitionRepository: CompetitionRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AllCompetitionsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AllCompetitionsViewModel(remoteRepository, competitionRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

}
}