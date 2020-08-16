package com.sun3toline.fico.data

import com.sun3toline.fico.BuildConfig
import io.reactivex.Single

class HomeFactory(private val dataSource: HomeDataSource) {
    fun discoverMovie(page: Long): Single<HomeResponse> = dataSource.discoverMovie(
        BuildConfig.API_KEY,
        page
    )
}