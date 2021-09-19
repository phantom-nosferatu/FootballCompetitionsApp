package com.bignerdranch.android.footballcompetitions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.footballcompetitions.data.remote.api.Repository
import com.bignerdranch.android.footballcompetitions.model.competition.MainCompetition
import kotlinx.coroutines.launch
import retrofit2.Response

class AllCompetitionsViewModel(private val repository: Repository) : ViewModel() {

    val competitionsResponse: MutableLiveData<Response<MainCompetition>> = MutableLiveData()

    fun getCompetitions() {

        viewModelScope.launch {
            val response = repository.getCompetitions()
            competitionsResponse.value = response
        }
    }
}