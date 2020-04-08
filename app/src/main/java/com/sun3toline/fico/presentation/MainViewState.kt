package com.sun3toline.fico.presentation

import com.sun3toline.fico.data.network.models.CountryResponse

sealed class MainViewState {
    object loading : MainViewState()

    data class Success(val response: CountryResponse) : MainViewState()
    data class Error(val error: Throwable) : MainViewState()
}