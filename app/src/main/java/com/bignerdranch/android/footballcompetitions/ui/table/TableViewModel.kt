package com.bignerdranch.android.footballcompetitions.ui.table

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.footballcompetitions.data.local.repository.TableRepository
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.Table
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.TableResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class TableViewModel(
    private val remoteRepository: RemoteRepository,
    private val tableRepository: TableRepository
) : ViewModel() {

    val tableResponse: MutableLiveData<Response<TableResponse>> = MutableLiveData()
    val tableLocal: MutableLiveData<List<Table>> = MutableLiveData()

    fun getTables(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            tableResponse.postValue(remoteRepository.getTables(id))
        }
    }

    fun saveTable(id : Int, table: List<Table>) {
        viewModelScope.launch {
            tableRepository.saveTable(id, table)
        }
    }

    fun getTableLocal(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            tableLocal.postValue(tableRepository.getTables(id))
        }
    }
}