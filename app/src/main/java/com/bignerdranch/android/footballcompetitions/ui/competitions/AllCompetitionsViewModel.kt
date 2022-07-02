package com.bignerdranch.android.footballcompetitions.ui.competitions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.footballcompetitions.data.local.repository.CompetitionRepository
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository
import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.Competition
import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.CompetitionResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class AllCompetitionsViewModel(private val remoteRepository: RemoteRepository , private val competitionRepository: CompetitionRepository) : ViewModel() {

    val competitionsResponse: MutableLiveData<Response<CompetitionResponse>> = MutableLiveData()
    val competitionsLocal : MutableLiveData<List<Competition>> = MutableLiveData()

    fun getCompetitions() {
        viewModelScope.launch {
            competitionsResponse.value = remoteRepository.getCompetitions()
        }
    }

    fun saveCompetitions(competition : List<Competition>) {
        viewModelScope.launch {
            competitionRepository.saveCompetition(competition)
        }
    }

    fun getCompetitionsLocal() {
        viewModelScope.launch {
            competitionsLocal.postValue(competitionRepository.getAllCompetition())
        }
    }
}