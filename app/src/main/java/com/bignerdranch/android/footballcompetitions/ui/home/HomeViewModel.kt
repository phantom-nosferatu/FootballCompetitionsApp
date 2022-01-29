package com.bignerdranch.android.footballcompetitions.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.footballcompetitions.data.remote.api.Repository
import com.bignerdranch.android.footballcompetitions.data.remote.model.matches.MatchesResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val repository: Repository) : ViewModel() {

    val matchesResponse : MutableLiveData<Response<MatchesResponse>> = MutableLiveData()

    fun getMatches() {

        viewModelScope.launch {
            val response = repository.getMatches()
            matchesResponse.value = response
        }
    }
}