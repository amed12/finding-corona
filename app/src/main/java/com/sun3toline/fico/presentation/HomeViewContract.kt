package com.sun3toline.fico.presentation

import androidx.lifecycle.LiveData

interface HomeViewContract {
    fun showTotalConfirmed()
    val states: LiveData<MainViewState>
}