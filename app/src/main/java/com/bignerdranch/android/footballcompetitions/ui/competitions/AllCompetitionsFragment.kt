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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.footballcompetitions.R
import com.bignerdranch.android.footballcompetitions.data.local.db.AppDatabase
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository
import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.Competition
import com.bignerdranch.android.footballcompetitions.utils.NetworkConnection
import java.util.Collections.emptyList

class AllCompetitionsFragment : Fragment() {

    private lateinit var allCompetitionsViewModel: AllCompetitionsViewModel
    private lateinit var competitionRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var loadingText: TextView
    private lateinit var db: AppDatabase
    private val networkConnection = NetworkConnection()
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
        val repository = RemoteRepository()
        val viewModelFactory = AllCompetitionsViewModelFactory(repository)

        allCompetitionsViewModel =
            ViewModelProvider(this, viewModelFactory)[AllCompetitionsViewModel::class.java]

        allCompetitionsViewModel.getCompetitions()

        allCompetitionsViewModel.competitionsResponse.observe(
            viewLifecycleOwner,
            { response ->
                if (response.isSuccessful) {
                    val result = response.body()?.competitions
                    Log.d("TAG", "Database saved!!!")
                    updateUI(result!!)
                } else {
                    Log.d("TAG", response.errorBody().toString())
                }
            })
    }

    private fun updateUI(competitions: List<Competition>) {
        adapter = AllCompetitionsAdapter(competitions)
        competitionRecyclerView.adapter = adapter
        loadingText.visibility = GONE
        progressBar.visibility = GONE
        competitionRecyclerView.visibility = VISIBLE

    }

}