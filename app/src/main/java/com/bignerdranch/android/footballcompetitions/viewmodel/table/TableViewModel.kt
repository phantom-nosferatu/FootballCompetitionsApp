package com.bignerdranch.android.footballcompetitions.viewmodel.table

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.footballcompetitions.data.remote.api.Repository
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.TableResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class TableViewModel(private val repository: Repository) : ViewModel() {

    val tableResponse: MutableLiveData<Response<TableResponse>> = MutableLiveData()

    fun getTables(id: Int) {
        viewModelScope.launch {
            val response = repository.getTables(id)
            tableResponse.value = response
        }
    }
}