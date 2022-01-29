package com.bignerdranch.android.footballcompetitions.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.footballcompetitions.R
import com.bignerdranch.android.footballcompetitions.data.remote.model.matches.Match

class HomeAdapter(val matches : List<Match>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val homeClub : TextView = itemView.findViewById(R.id.text_homeClub)
    val awayClub : TextView = itemView.findViewById(R.id.text_awayClub)
    val homeScore : TextView = itemView.findViewById(R.id.text_homeScore)
    val awayScore : TextView = itemView.findViewById(R.id.text_awayScore)
    val duration : TextView = itemView.findViewById(R.id.text_duration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.match_row_item , parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val match = matches[position]
        holder.homeClub.text = match.homeTeam.name
        holder.awayClub.text = match.awayTeam.name
        holder.homeScore.text = match.score.fullTime.homeTeam.toString()
        holder.awayScore.text = match.score.fullTime.awayTeam.toString()
        holder.duration.text = "${match.score.duration}'"
    }

    override fun getItemCount() = matches.size
}