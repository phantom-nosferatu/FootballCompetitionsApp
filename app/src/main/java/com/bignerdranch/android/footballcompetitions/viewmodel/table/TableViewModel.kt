package com.bignerdranch.android.footballcompetitions.viewmodel.table

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.footballcompetitions.data.remote.api.Repository
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.TableResponse
import okhttp3.Response

class TableViewModel(private val repository: Repository) : ViewModel(){

    val tableResponse : MutableLiveData<Response<TableResponse>> = MutableLiveData()

    fun getTables(id: Int) {
            val response = repository.getTables(id)
            tableResponse.value = response
    }
}