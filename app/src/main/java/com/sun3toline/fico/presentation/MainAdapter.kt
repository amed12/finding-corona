package com.sun3toline.fico.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sun3toline.fico.R
import com.sun3toline.fico.data.network.models.CountryResponse

class MainAdapter(private val result: List<CountryResponse.Country>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(country: CountryResponse.Country) {
            with(itemView) {
                val tvCountry: TextView = findViewById(R.id.tv_country_name)
                val tvTotalCase: TextView = findViewById(R.id.tv_total_case)
                tvCountry.text = country.country
                tvTotalCase.text = country.totalConfirmed.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_country,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(result[holder.adapterPosition])
    }
}