package com.bignerdranch.android.footballcompetitions.ui.table

import android.os.Bundle
import android.util.Log
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
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.Table
import com.bignerdranch.android.footballcompetitions.utils.NetworkConnection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Collections.emptyList

class TableFragment : Fragment() {
    private lateinit var tableRecyclerView: RecyclerView
    private var adapter: TableAdapter? = TableAdapter(emptyList())
    private val networkConnection = NetworkConnection()
    val name = arguments?.getString("name")

    private val viewModel : TableViewModel by viewModels {
        TableViewModelFactory(RemoteRepository(), App().tableRepository)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_table, container, false)
        tableRecyclerView = view.findViewById(R.id.recyclerView_table)
        tableRecyclerView.adapter = adapter
        tableRecyclerView.layoutManager = LinearLayoutManager(context)
        tableRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id = arguments?.getInt("id")

        when (networkConnection.internetIsActive(context)) {
            true -> getRemoteTables(id!!)
            false -> getLocalTables(id!!)
        }
    }

    private fun getLocalTables(id : Int) {
        viewModel.getTableLocal(id)

        viewModel.tableLocal.observe(viewLifecycleOwner) {
            updateUI(it)
        }
    }

    private fun getRemoteTables(id : Int) {
        viewModel.getTables(id)

        viewModel.tableResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                val result = response.body()?.standings?.flatMap { it.table }
                updateUI(result!!)
                viewModel.saveTable(id, result)
            } else {
                Log.d("TAG", response.errorBody().toString())
            }
        }
    }


    private fun updateUI(table: List<Table>) {
        CoroutineScope(Dispatchers.Main).launch {
            adapter = TableAdapter(table)
            tableRecyclerView.adapter = adapter
        }

    }
}
