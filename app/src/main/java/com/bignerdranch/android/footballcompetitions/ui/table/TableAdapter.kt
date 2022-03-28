package com.bignerdranch.android.footballcompetitions.ui.table

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.footballcompetitions.R
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.Table
import com.bignerdranch.android.footballcompetitions.utils.SVGLoader

class TableAdapter(val tables: List<Table>) : RecyclerView.Adapter<TableAdapter.TableViewHolder>() {


    class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val logoClub: ImageView = itemView.findViewById(R.id.image_logoClub)
        val nameClub: TextView = itemView.findViewById(R.id.text_nameClub)
        val positionClub : TextView = itemView.findViewById(R.id.text_positionClub)
        val pointClub : TextView = itemView.findViewById(R.id.text_pointClub)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.table_row_item, parent, false)
        return TableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val table = tables[position]
        holder.nameClub.text = table.team.name
        holder.positionClub.text = "${table.position}."
        holder.pointClub.text = table.points.toString()
        val svgLoader = SVGLoader()
        svgLoader.loadImage(table.team.crestUrl, holder.itemView.context, holder.logoClub)

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("teamName", table.team.name)
            bundle.putInt("teamID", table.team.id)
            Navigation.findNavController(holder.itemView).navigate(R.id.action_tableFragment_to_teamFragment, bundle)
        }
    }

    override fun getItemCount() = tables.size
}