package com.ennoblesoft.expandablerecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ennoblesoft.expandablerecyclerview.R
import com.ennoblesoft.expandablerecyclerview.models.NewspaperModel

class NewspaperAdapter(context: Context, data: List<NewspaperModel>?) :
        RecyclerView.Adapter<NewspaperAdapter.NewspaperViewHolder>() {
    private var mContext: Context = context
    private var items: List<NewspaperModel>? = data
    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var headlineAdapter: HeadlinesAdapter? = null

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewspaperViewHolder {
        val view = inflater.inflate(R.layout.item_news_paper, parent, false)
        return NewspaperViewHolder(view)
    }

    override
    fun onBindViewHolder(holder: NewspaperViewHolder, position: Int) {
        val item = items?.get(position)

        holder.tvName.text = item?.paperName
        headlineAdapter = HeadlinesAdapter(mContext, item?.paperHeadlines)
        holder.rvHeadlines.adapter = headlineAdapter
        holder.rvHeadlines.layoutManager = LinearLayoutManager(mContext)
        holder.ivArrow.setOnClickListener { onItemClicked(item) }
        if (item?.isExpanded!!) {
            holder.rvHeadlines.visibility = View.VISIBLE
            holder.ivArrow.setImageResource(R.drawable.ic_arrow_up)
        } else {
            holder.rvHeadlines.visibility = View.GONE
            holder.ivArrow.setImageResource(R.drawable.ic_arrow_down)
        }
    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    private fun onItemClicked(newspaperModel: NewspaperModel?) {
        newspaperModel?.isExpanded = !newspaperModel?.isExpanded!!
        notifyDataSetChanged()
    }

    class NewspaperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvPaperName)
        var rvHeadlines: RecyclerView = itemView.findViewById(R.id.rvHeadlines)
        var ivArrow: ImageView = itemView.findViewById(R.id.ivArrow)
    }
}