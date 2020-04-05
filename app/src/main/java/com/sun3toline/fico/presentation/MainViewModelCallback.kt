package com.sun3toline.fico.presentation

import com.sun3toline.fico.data.network.models.CountryResponse

interface MainViewModelCallback {
    fun onSuccess(result: List<CountryResponse.Country>)
    fun onError(error: Throwable)
}