package com.bignerdranch.android.footballcompetitions.ui.competitions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.footballcompetitions.App
import com.bignerdranch.android.footballcompetitions.R
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository
import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.Competition
import com.bignerdranch.android.footballcompetitions.utils.NetworkConnection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Collections.emptyList

class AllCompetitionsFragment : Fragment() {

    private lateinit var competitionRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var loadingText: TextView
    private val networkConnection = NetworkConnection()
    private val viewModel : AllCompetitionsViewModel by viewModels {
        AllCompetitionsViewModelFactory(RemoteRepository(), App().competitionRepository)
    }
    private var adapter: AllCompetitionsAdapter? = AllCompetitionsAdapter(emptyList())


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_competitions, container, false)
        competitionRecyclerView = view.findViewById(R.id.recyclerView_allCompetitions)
        progressBar = view.findViewById(R.id.loadProgressBar)
        loadingText = view.findViewById(R.id.loadTextView)
        competitionRecyclerView.adapter = adapter
        competitionRecyclerView.layoutManager = LinearLayoutManager(context)
        competitionRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        when(networkConnection.internetIsActive(context)) {
            true -> getRemoteCompetitions()
            false -> getLocalCompetitions()

        }

    }

    private fun getLocalCompetitions() {
        viewModel.getCompetitionsLocal()

        viewModel.competitionsLocal.observe(viewLifecycleOwner) {
            updateUI(it)
        }
    }

    private fun getRemoteCompetitions() {
        viewModel.getCompetitions()

        viewModel.competitionsResponse.observe(
            viewLifecycleOwner
        ) { response ->
            if (response.isSuccessful) {
                val result = response.body()?.competitions
                updateUI(result!!)
                viewModel.saveCompetitions(result)
            } else {
                Log.d("TAG", response.errorBody().toString())
            }
        }
    }

    private fun updateUI(competitions: List<Competition>) {
        CoroutineScope(Dispatchers.Main).launch {
            adapter = AllCompetitionsAdapter(competitions)
            competitionRecyclerView.adapter = adapter
            loadingText.visibility = GONE
            progressBar.visibility = GONE
            competitionRecyclerView.visibility = VISIBLE  }


    }

}