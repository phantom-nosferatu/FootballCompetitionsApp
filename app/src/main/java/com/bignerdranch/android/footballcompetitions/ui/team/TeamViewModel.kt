package com.bignerdranch.android.footballcompetitions.ui.team

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.footballcompetitions.data.local.repository.TeamRepository
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository
import com.bignerdranch.android.footballcompetitions.data.remote.model.team.Squad
import com.bignerdranch.android.footballcompetitions.data.remote.model.team.TeamResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class TeamViewModel (private val remoteRepository: RemoteRepository, private val teamRepository: TeamRepository) : ViewModel() {

    val teamResponse : MutableLiveData<Response<TeamResponse>> = MutableLiveData()
    val teamLocal : MutableLiveData<List<Squad>> = MutableLiveData()

    fun getTeam(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            teamResponse.postValue(remoteRepository.getTeam(id))
        }
    }

    fun saveTeam(id : Int, team : List<Squad>) {
        viewModelScope.launch {
            teamRepository.saveTeam(id, team)
        }
    }

    fun getTeamLocal(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            teamLocal.postValue(teamRepository.getTeam(id))
        }
    }
}