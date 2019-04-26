package com.ennoblesoft.expandablerecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ennoblesoft.expandablerecyclerview.R
import com.ennoblesoft.expandablerecyclerview.models.HeadlinesModel

class HeadlinesAdapter(context: Context, data: List<HeadlinesModel>?) :
        RecyclerView.Adapter<HeadlinesAdapter.HeadlinesViewHolder>() {
    private var items: List<HeadlinesModel>? = data
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlinesViewHolder {
        val view = inflater.inflate(R.layout.item_headlines, parent, false)
        return HeadlinesViewHolder(view)
    }

    override
    fun onBindViewHolder(holder: HeadlinesViewHolder, position: Int) {
        val item = items?.get(position)

        holder.tvTitle.text = item?.title
        holder.tvDescription.text = item?.description
    }

    override
    fun getItemCount(): Int {
        return items?.size?:0
    }

    class HeadlinesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        var tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }
}