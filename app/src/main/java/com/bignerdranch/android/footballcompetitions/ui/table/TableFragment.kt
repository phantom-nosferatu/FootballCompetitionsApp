package com.bignerdranch.android.footballcompetitions.ui.table

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.footballcompetitions.R
import com.bignerdranch.android.footballcompetitions.data.remote.api.Repository
import com.bignerdranch.android.footballcompetitions.viewmodel.table.TableViewModel
import com.bignerdranch.android.footballcompetitions.viewmodel.table.TableViewModelFactory

class TableFragment : Fragment() {

    private lateinit var tableViewModel : TableViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_table, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repository = Repository()
        val viewModelFactory = TableViewModelFactory(repository)
        tableViewModel = ViewModelProvider(this, viewModelFactory).get(TableViewModel::class.java)
    }
}