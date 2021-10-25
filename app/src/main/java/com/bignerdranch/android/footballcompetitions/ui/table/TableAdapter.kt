package com.bignerdranch.android.footballcompetitions.ui.table

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.footballcompetitions.R
import com.bignerdranch.android.footballcompetitions.data.remote.model.table.Table
import com.bignerdranch.android.footballcompetitions.utils.SVGLoader

class TableAdapter(val tables: List<Table>) : RecyclerView.Adapter<TableAdapter.TableViewHolder>() {


    class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val logoClub: ImageView = itemView.findViewById(R.id.image_logoClub)
        val nameClub: TextView = itemView.findViewById(R.id.text_nameClub)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.table_row_item, parent, false)
        return TableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val table = tables[position]
        holder.nameClub.text = "${table.position}. ${table.team.name}"
        val svgLoader = SVGLoader()
        svgLoader.loadImage(table.team.crestUrl, holder.itemView.context, holder.logoClub)
    }

    override fun getItemCount() = tables.size
}