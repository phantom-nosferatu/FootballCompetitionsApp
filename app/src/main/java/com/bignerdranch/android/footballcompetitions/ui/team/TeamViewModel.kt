package com.bignerdranch.android.footballcompetitions.ui.team

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.footballcompetitions.data.remote.api.Repository
import com.bignerdranch.android.footballcompetitions.data.remote.model.team.TeamResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class TeamViewModel (private val repository: Repository) : ViewModel() {

    val teamResponse : MutableLiveData<Response<TeamResponse>> = MutableLiveData()

    fun getTeam(id: Int) {
        viewModelScope.launch {
            val response = repository.getTeam(id)
            teamResponse.value = response
        }
    }
}