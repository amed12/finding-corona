package com.sun3toline.fico.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun3toline.fico.R
import com.sun3toline.fico.data.network.models.CountryResponse
import kotlinx.android.synthetic.main.item_country.view.*

class MainAdapter(private val result: List<CountryResponse.Country>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(result: CountryResponse.Country) {
            with(itemView) {
                tv_total_case.text = result.totalConfirmed.toString()
                tv_country_name.text = result.country
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_country,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return result.count()
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(result[holder.adapterPosition])
    }
}