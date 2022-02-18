package com.bignerdranch.android.footballcompetitions.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.footballcompetitions.data.local.entity.MatchesEntity
import com.bignerdranch.android.footballcompetitions.data.local.repository.MatchRepository
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository
import com.bignerdranch.android.footballcompetitions.data.remote.model.matches.Match
import com.bignerdranch.android.footballcompetitions.data.remote.model.matches.MatchesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(
    private val remoteRepository: RemoteRepository,
    private val matchRepository: MatchRepository
) : ViewModel() {

    val matchesResponse: MutableLiveData<Response<MatchesResponse>> = MutableLiveData()

    fun getMatchesRemote() {
        viewModelScope.launch {
            val response = remoteRepository.getMatches()
            matchesResponse.value = response
        }
    }

    fun saveMatches(match: List<Match>) {
        viewModelScope.launch(Dispatchers.IO) {
            matchRepository.saveMatches(match)
        }
    }

   suspend fun getMatchesLocal() : List<Match> {
        return matchRepository.getMatches()
    }
}