package com.sun3toline.fico.presentation

import com.sun3toline.fico.data.network.CountryDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class HomePresenter(
    private val viewContract: HomeViewContract,
    private val dataSource: CountryDataSource
) {
    private val disposable = CompositeDisposable()
    fun showDeathFromAllCountry() {
        viewContract.onShowLoading()
        dataSource.getSummary()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewContract.onHideLoading()
                it?.countries?.let { it1 -> viewContract.onResponse(it1) }
            }, {
                viewContract.onHideLoading()
                viewContract.onFailure(it)
            }).addTo(disposable)
//            .enqueue(object : Callback<CountryResponse>{
//            override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
//                viewContract.onHideLoading()
//                viewContract.onFailure(t)
//            }
//
//            override fun onResponse(
//                call: Call<CountryResponse>,
//                response: Response<CountryResponse>
//            ) {
//                viewContract.onHideLoading()
//                response.body()?.countries?.let { viewContract.onResponse(it) }
//            }
//        })
    }

    fun onDestroy() {
        disposable.clear()
    }
}