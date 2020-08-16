package com.sun3toline.fico.presentation

import androidx.lifecycle.LiveData
import com.sun3toline.fico.domain.HomeEntity

interface HomeViewContract {
    fun onShowLoading()
    fun onHideLoading()
    fun onSuccess(entity: HomeEntity)
    fun onError(error: Throwable)
    fun onPaginationSuccess(entity: HomeEntity)
    fun onPaginationError(error: Throwable)
    fun showTotalConfirmed()
    val states: LiveData<MainViewState>
}