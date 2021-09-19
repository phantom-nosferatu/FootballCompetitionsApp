package com.bignerdranch.android.footballcompetitions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.footballcompetitions.data.remote.api.Repository

class AllCompetitionsFragment : Fragment() {

     private lateinit var allCompetitionsViewModel: AllCompetitionsViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_competitions, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repository = Repository()
        val viewModelFactory = AllCompetitionsViewModelFactory(repository)
        allCompetitionsViewModel = ViewModelProvider(this, viewModelFactory).get(AllCompetitionsViewModel::class.java)

        allCompetitionsViewModel.getCompetitions()

        allCompetitionsViewModel.competitionsResponse.observe(viewLifecycleOwner, {
            response ->
            if (response.isSuccessful) {

            } else {
                Log.d("TAG", response.errorBody().toString())
            }
        })
    }

}

private class AllCompetitionsHolder(view: View) : RecyclerView.ViewHolder(view) {

}