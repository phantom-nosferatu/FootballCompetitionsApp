package com.bignerdranch.android.footballcompetitions.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    val localResponse : MutableLiveData<List<Match>> = MutableLiveData()

    fun getMatchesRemote() {
        viewModelScope.launch(Dispatchers.IO) {
            matchesResponse.postValue(remoteRepository.getMatches())
        }
    }

    fun saveMatches(match: List<Match>) {
        viewModelScope.launch(Dispatchers.IO) {
            matchRepository.saveMatches(match)
        }
    }

      fun getMatchesLocal() {
          viewModelScope.launch(Dispatchers.IO) {
              localResponse.postValue(matchRepository.getMatches())
          }
      }
    }