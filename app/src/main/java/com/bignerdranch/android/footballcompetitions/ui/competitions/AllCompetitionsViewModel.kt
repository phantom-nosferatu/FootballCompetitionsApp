package com.bignerdranch.android.footballcompetitions.ui.competitions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.footballcompetitions.data.local.repository.CompetitionRepository
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository
import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.CompetitionResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class AllCompetitionsViewModel(private val remoteRepository: RemoteRepository , private val competitionRepository: CompetitionRepository) : ViewModel() {

    val competitionsResponse: MutableLiveData<Response<CompetitionResponse>> = MutableLiveData()

    fun getCompetitions() {
        viewModelScope.launch {
            val response = remoteRepository.getCompetitions()
            competitionsResponse.value = response
        }
    }
}