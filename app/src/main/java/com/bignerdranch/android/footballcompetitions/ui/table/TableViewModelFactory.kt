package com.bignerdranch.android.footballcompetitions.ui.table

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository


@Suppress("UNCHECKED_CAST")
class TableViewModelFactory(private val remoteRepository: RemoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TableViewModel(remoteRepository) as T
    }
}