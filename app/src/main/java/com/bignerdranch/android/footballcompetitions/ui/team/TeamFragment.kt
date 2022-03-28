package com.bignerdranch.android.footballcompetitions.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.footballcompetitions.App
import com.bignerdranch.android.footballcompetitions.R
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository
import com.bignerdranch.android.footballcompetitions.data.remote.model.team.Squad
import com.bignerdranch.android.footballcompetitions.utils.NetworkConnection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TeamFragment : Fragment() {

    private lateinit var teamRecyclerView: RecyclerView
    private var adapter: TeamAdapter? = TeamAdapter(emptyList())
    private val networkConnection = NetworkConnection()
    val name = arguments?.getString("teamName")

    private val viewModel: TeamViewModel by viewModels {
        TeamViewModelFactory(RemoteRepository(), App().teamRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_team, container, false)
        teamRecyclerView = view.findViewById(R.id.recyclerView_team)
        teamRecyclerView.adapter = adapter
        teamRecyclerView.layoutManager = LinearLayoutManager(context)
        teamRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt("teamID")

        when (networkConnection.internetIsActive(context)) {
            true -> getTeamRemote(id!!)
            false -> getTeamLocal(id!!)
        }

    }

    private fun getTeamLocal(id: Int) {
        viewModel.getTeamLocal(id)

        viewModel.teamLocal.observe(viewLifecycleOwner) {
            updateUI(it)
        }
    }

    private fun getTeamRemote(id: Int) {
        viewModel.getTeam(id)

        viewModel.teamResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                val result = response.body()?.squad
                updateUI(result!!)
                viewModel.saveTeam(id, result)
            } else {
                getTeamLocal(id)
            }
        }
    }

    private fun updateUI(team: List<Squad>) {
        CoroutineScope(Dispatchers.Main).launch {
            adapter = TeamAdapter(team)
            teamRecyclerView.adapter = adapter
        }
    }
}