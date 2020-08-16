package com.sun3toline.fico.domain

import io.reactivex.Single

interface HomeRepository {
    fun discoverMovie(param: HomeParam): Single<HomeEntity>
}