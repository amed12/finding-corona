package com.sun3toline.fico.presentation

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun3toline.fico.R
import com.sun3toline.fico.domain.HomeEntity
import kotlinx.android.synthetic.main.item_country.view.*

enum class Type {
    DATA,
    LOADING
}

class HomeAdapter(private var results: MutableList<HomeEntity.Result?>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            Type.DATA.ordinal -> {
                HomeViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_country, parent, false)
                )
            }
            Type.LOADING.ordinal -> {
                LoadingViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_loading, parent, false)
                )
            }
            else -> throw RuntimeException("Illegal view type")
        }

    override fun getItemCount(): Int = results.count()

    override fun getItemViewType(position: Int): Int =
        if (results[position] == null) Type.LOADING.ordinal else Type.DATA.ordinal

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeViewHolder)
            holder.bind(results[holder.adapterPosition])
    }

    fun showLoading() {
        results.add(null)
        Handler().post { notifyItemInserted(results.count().minus(1)) }
    }

    fun hideLoading() {
        results.removeAt(results.count().minus(1))
        Handler().post { notifyItemRemoved(results.count()) }
    }

    fun loadMore(results: MutableList<HomeEntity.Result?>) {
        this.results.addAll(results)
        Handler().post { notifyDataSetChanged() }
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result: HomeEntity.Result?) {
            with(itemView) {
                tv_country_name.text = result?.title ?: "Untitled"
                tv_total_case?.text = result?.overView ?: "No Description"
            }
        }
    }

    inner class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}