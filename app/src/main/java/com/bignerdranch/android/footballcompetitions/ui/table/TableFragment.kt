package com.bignerdranch.android.footballcompetitions.ui.table

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.footballcompetitions.R
import com.bignerdranch.android.footballcompetitions.data.remote.api.RemoteRepository
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.Table
import java.util.Collections.emptyList

class TableFragment : Fragment() {

    private lateinit var tableViewModel: TableViewModel
    private lateinit var tableRecyclerView: RecyclerView
    private var adapter: TableAdapter? = TableAdapter(emptyList())
    val name = arguments?.getString("name")



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
        val repository = RemoteRepository()
        val viewModelFactory = TableViewModelFactory(repository)
        tableViewModel = ViewModelProvider(this, viewModelFactory)[TableViewModel::class.java]
        val id = arguments?.getInt("id")

        getTable(id)
    }

    private fun getTable(id: Int?) {
        tableViewModel.getTables(id!!)

        tableViewModel.tableResponse.observe(viewLifecycleOwner, {
                response ->
            if (response.isSuccessful) {
                val result = response.body()?.standings?.flatMap { it.table }
                updateUI(result!!)
            } else {
                Log.d("TAG",response.errorBody().toString())
            }
        })
    }

    private fun updateUI(table: List<Table>) {
        adapter = TableAdapter(table)
        tableRecyclerView.adapter = adapter
    }
}
