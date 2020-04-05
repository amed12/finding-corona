package com.sun3toline.fico.presentation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sun3toline.fico.data.network.models.CountryResponse

class MainAdapterViewModel(result: CountryResponse.Country) : BaseObservable() {
    val country: String = result.country
        @Bindable get

    val totalConfirmed: String = result.totalConfirmed.toString()
        @Bindable get
}