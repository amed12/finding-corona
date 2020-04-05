package com.sun3toline.fico.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sun3toline.fico.R
import com.sun3toline.fico.data.network.models.CountryResponse
import com.sun3toline.fico.databinding.ItemCountryBinding

class MainAdapter(private val result: List<CountryResponse.Country>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
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
        holder.binding.apply {
            viewModel = MainAdapterViewModel(result[holder.adapterPosition])
            executePendingBindings()
        }
    }
}