package com.bignerdranch.android.footballcompetitions.ui.team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.footballcompetitions.R
import com.bignerdranch.android.footballcompetitions.data.remote.model.team.Squad

class TeamAdapter(private val teams: List<Squad>) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    class TeamViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val namePlayer : TextView = itemView.findViewById(R.id.tv_namePlayer)
        val positionPlayer : TextView = itemView.findViewById(R.id.tv_positionPlayer)
        val yearPlayer : TextView = itemView.findViewById(R.id.tv_year)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.team_row_item, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.namePlayer.text = team.name
        holder.positionPlayer.text = team.position
        holder.yearPlayer.text = team.dateOfBirth.substring(0, 4)
    }

    override fun getItemCount() = teams.size
}