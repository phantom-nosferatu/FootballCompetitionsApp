package com.bignerdranch.android.footballcompetitions.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.webkit.RenderProcessGoneDetail
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
import com.bignerdranch.android.footballcompetitions.data.remote.model.matches.Match
import com.bignerdranch.android.footballcompetitions.utils.NetworkConnection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var loadingText: TextView
    private var adapter: HomeAdapter? = HomeAdapter(emptyList())
    private val networkConnection = NetworkConnection()
    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(RemoteRepository(), App().matchRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView_matches)
        progressBar = view.findViewById(R.id.loadProgressBar)
        loadingText = view.findViewById(R.id.loadTextView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        when (networkConnection.internetIsActive(context)) {
            true -> getRemoteMatches()
            false -> getLocalMatches()
        }

    }

    private fun updateUI(match: List<Match>) {
        adapter = HomeAdapter(match)
        recyclerView.adapter = adapter
        loadingText.visibility = GONE
        progressBar.visibility = GONE
        recyclerView.visibility = VISIBLE
    }

    private fun getRemoteMatches() {
        viewModel.getMatchesRemote()

        viewModel.matchesResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                val result = response.body()?.matches
                viewModel.saveMatches(result!!)
                updateUI(result)

            } else {
                getLocalMatches()
            }
        }
    }

    private fun getLocalMatches() {
        viewModel.getMatchesLocal()

        viewModel.localResponse.observe(viewLifecycleOwner) {
            updateUI(it)
        }
    }

}