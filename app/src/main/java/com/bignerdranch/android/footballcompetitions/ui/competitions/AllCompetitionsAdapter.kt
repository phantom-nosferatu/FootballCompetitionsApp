package com.bignerdranch.android.footballcompetitions.ui.competitions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.footballcompetitions.R
import com.bignerdranch.android.footballcompetitions.data.remote.model.competition.Competition

class AllCompetitionsAdapter(val competitions: List<Competition>) :
    RecyclerView.Adapter<AllCompetitionsAdapter.AllCompetitionsViewHolder>() {

    inner class AllCompetitionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameCompetition: TextView = itemView.findViewById(R.id.text_competitionName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCompetitionsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.competition_row_item, parent, false)
        return AllCompetitionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllCompetitionsViewHolder, position: Int) {
        val competition = competitions[position]
        holder.nameCompetition.text = competition.name
        holder.itemView.setOnClickListener {
            val action =
                AllCompetitionsFragmentDirections.actionAllCompetitionsFragmentToTableFragment(
                    competition.id
                )
            Navigation.findNavController(holder.itemView).navigate(action)
        }

    }

    override fun getItemCount()= competitions.size
}


