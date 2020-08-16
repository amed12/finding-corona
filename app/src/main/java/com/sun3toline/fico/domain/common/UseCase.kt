package com.sun3toline.fico.domain.common

import com.sun3toline.fico.domain.executor.PostExecutionThread
import com.sun3toline.fico.domain.executor.ThreadExecutor
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, in Params>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {
    private val disposable = CompositeDisposable()
    protected abstract fun buildUseCaseObservable(params: Params): Single<T>

    fun execute(observer: DefaultObserver<T>, params: Params) {
        buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
            .subscribeWith(observer)
            .addTo(disposable)
    }

    fun dispose() {
        disposable.clear()
    }
}