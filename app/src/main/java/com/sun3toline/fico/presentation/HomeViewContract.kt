package com.sun3toline.fico.presentation

import com.sun3toline.fico.data.network.models.CountryResponse

interface HomeViewContract {
    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(results: List<CountryResponse.Country>)
    fun onFailure(error: Throwable)
}