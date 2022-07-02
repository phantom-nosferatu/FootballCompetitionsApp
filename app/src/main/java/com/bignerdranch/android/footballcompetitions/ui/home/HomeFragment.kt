package com.bignerdranch.android.footballcompetitions.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.webkit.RenderProcessGoneDetail
import android.widget.Button
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
import com.bignerdranch.android.footballcompetitions.utils.ErrorProgress
import com.bignerdranch.android.footballcompetitions.utils.NetworkConnection
import com.bignerdranch.android.footballcompetitions.utils.PendingProgress
import com.bignerdranch.android.footballcompetitions.utils.SuccessProgress
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorText: TextView
    private lateinit var tryAgainButton: Button
    private var adapter: HomeAdapter? = HomeAdapter(emptyList())
    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(RemoteRepository(), App().matchRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView_matches)
        progressBar = view.findViewById(R.id.progressBar)
        errorText = view.findViewById(R.id.text_error)
        tryAgainButton = view.findViewById(R.id.btn_tryAgain)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getMatchesRemote()
        viewModel.matchesResponse.observe(viewLifecycleOwner) { progress ->
            when (progress) {
                is PendingProgress -> {
                    progressBar.visibility = VISIBLE
                    errorText.visibility = GONE
                    tryAgainButton.visibility = GONE
                    recyclerView.visibility = GONE
                }
                is ErrorProgress -> {
                    progressBar.visibility = VISIBLE
                    errorText.visibility = VISIBLE
                    tryAgainButton.visibility = VISIBLE
                    recyclerView.visibility = GONE
                }
                is SuccessProgress -> {
                    updateUI(progress.data.body()!!.matches)
                    recyclerView.visibility = VISIBLE
                    progressBar.visibility = GONE
                    errorText.visibility = GONE
                    tryAgainButton.visibility = GONE
                }
            }

        }

    }

    private fun updateUI(match: List<Match>) {
        adapter = HomeAdapter(match)
        recyclerView.adapter = adapter
    }

}