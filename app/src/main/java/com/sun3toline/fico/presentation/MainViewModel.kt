package com.sun3toline.fico.presentation

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sun3toline.fico.BR
import com.sun3toline.fico.data.network.CountryDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MainViewModel(
    private val callback: MainViewModelCallback,
    private val dataSource: CountryDataSource
) : BaseObservable(), HomeViewContract {

    var progressBarVisibility: Int = View.GONE
        @Bindable get

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun showTotalConfirmed() {
        progressBarVisibility = View.VISIBLE
        notifyPropertyChanged(BR.progressBarVisibility)
        dataSource.getSummary()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                progressBarVisibility = View.GONE
                notifyPropertyChanged(BR.progressBarVisibility)
                callback.onSuccess(response.countries.sortedByDescending { it.totalDeaths })
            }, { error ->
                progressBarVisibility = View.GONE
                notifyPropertyChanged(BR.progressBarVisibility)
                callback.onError(error)
            }).addTo(disposables)
    }

    override fun onDetach() {
        disposables.clear()
    }
}