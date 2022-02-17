package com.bignerdranch.android.footballcompetitions.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.footballcompetitions.R
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository

class TeamFragment : Fragment() {

private lateinit var viewModel: TeamViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_team, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = RemoteRepository()
        val viewModelFactory = TeamViewModelFactory(repository)
       viewModel = ViewModelProvider(this, viewModelFactory)[TeamViewModel::class.java]

        viewModel.getTeam(15)

        viewModel.teamResponse.observe(viewLifecycleOwner, {
            response ->
            if (response.isSuccessful) {
                TODO()
            } else {
                TODO()
            }
        })



    }
}