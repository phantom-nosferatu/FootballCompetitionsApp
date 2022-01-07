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
import com.bignerdranch.android.footballcompetitions.data.remote.api.Repository
import com.bignerdranch.android.footballcompetitions.viewmodel.table.TableViewModel
import com.bignerdranch.android.footballcompetitions.viewmodel.table.TableViewModelFactory
import java.util.Collections.emptyList

class TableFragment : Fragment() {

    private lateinit var tableViewModel : TableViewModel
    private lateinit var tableRecyclerView : RecyclerView
    private var adapter: TableAdapter? = TableAdapter(emptyList())


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_table, container, false)
        tableRecyclerView = view.findViewById(R.id.recyclerView_table)
        tableRecyclerView.adapter = adapter
        tableRecyclerView.layoutManager = LinearLayoutManager(context)
        tableRecyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repository = Repository()
        val viewModelFactory = TableViewModelFactory(repository)
        tableViewModel = ViewModelProvider(this, viewModelFactory).get(TableViewModel::class.java)
        val id = arguments?.getInt("id")

        ///tableViewModel.
    }
}
