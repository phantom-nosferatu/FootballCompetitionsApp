package com.bignerdranch.android.footballcompetitions.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.footballcompetitions.data.local.repository.MatchRepository
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository


class HomeViewModelFactory(private val remoteRepository: RemoteRepository, private val matchRepository: MatchRepository) : ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(remoteRepository , matchRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
