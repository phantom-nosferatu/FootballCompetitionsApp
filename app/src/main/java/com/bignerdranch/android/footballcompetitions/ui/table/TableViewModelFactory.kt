package com.bignerdranch.android.footballcompetitions.ui.table

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.footballcompetitions.data.local.repository.TableRepository
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository


class TableViewModelFactory(
    private val remoteRepository: RemoteRepository,
    private val tableRepository: TableRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TableViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TableViewModel(remoteRepository, tableRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}