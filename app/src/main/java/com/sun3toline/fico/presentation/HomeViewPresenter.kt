package com.sun3toline.fico.presentation

import com.sun3toline.fico.domain.HomeEntity
import com.sun3toline.fico.domain.HomeParam
import com.sun3toline.fico.domain.HomeUseCase
import com.sun3toline.fico.domain.common.DefaultObserver

class HomeViewPresenter(
    private val view: HomeViewContract,
    private val useCase: HomeUseCase
) {
    fun discoverMovie() {
        view.onShowLoading()
        useCase.execute(DiscoverMovieUseCase(), HomeParam())
    }

    fun loadMore(page: Long) {
        useCase.execute(LoadMoreUseCase(), HomeParam(page = page))
    }

    fun onDetach() {
        useCase.dispose()
    }

    inner class DiscoverMovieUseCase : DefaultObserver<HomeEntity>() {
        override fun onSuccess(entity: HomeEntity) {
            view.onHideLoading()
            view.onSuccess(entity)
        }

        override fun onError(exception: Throwable) {
            view.onHideLoading()
            view.onError(exception)
        }
    }

    inner class LoadMoreUseCase : DefaultObserver<HomeEntity>() {
        override fun onSuccess(entity: HomeEntity) {
            view.onPaginationSuccess(entity)
        }

        override fun onError(exception: Throwable) {
            view.onPaginationError(exception)
        }
    }
}