package com.sun3toline.fico.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sun3toline.fico.data.network.CountryDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val dataSource: CountryDataSource
) : ViewModel(), HomeViewContract {

    private val disposables: CompositeDisposable = CompositeDisposable()
    private val observer = MutableLiveData<MainViewState>()
    override val states: LiveData<MainViewState>
        get() = observer

    override fun showTotalConfirmed() {
        dataSource.getSummary()
            .observeOn(AndroidSchedulers.mainThread())
            .map<MainViewState>(MainViewState::Success)
            .onErrorReturn(MainViewState::Error)
            .toFlowable()
            .startWith(MainViewState.loading)
            .subscribe(observer::postValue)
            .let(disposables::add)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}