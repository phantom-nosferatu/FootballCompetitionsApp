package com.bignerdranch.android.footballcompetitions.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.footballcompetitions.data.local.repository.MatchRepository
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository
import com.bignerdranch.android.footballcompetitions.data.remote.model.matches.Match
import com.bignerdranch.android.footballcompetitions.data.remote.model.matches.MatchesResponse
import com.bignerdranch.android.footballcompetitions.utils.PendingProgress
import com.bignerdranch.android.footballcompetitions.utils.Progress
import com.bignerdranch.android.footballcompetitions.utils.SuccessProgress
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(
    private val remoteRepository: RemoteRepository,
    private val matchRepository: MatchRepository
) : ViewModel() {

    val matchesResponse = MutableLiveProgress<Response<MatchesResponse>>(PendingProgress())
    val localResponse : MutableLiveData<List<Match>> = MutableLiveData()

    fun getMatchesRemote() {
        viewModelScope.launch {
            matchesResponse.postValue(SuccessProgress(remoteRepository.getMatches()))
        }
    }

    fun saveMatches(match: List<Match>) {
        viewModelScope.launch {
            matchRepository.saveMatches(match)
        }
    }

      fun getMatchesLocal() {
          viewModelScope.launch {
              localResponse.postValue(matchRepository.getMatches())
          }
      }
    }

typealias MutableLiveProgress<T> = MutableLiveData<Progress<T>>