package com.sun3toline.fico.domain

import com.sun3toline.fico.data.HomeFactory
import io.reactivex.Single

class HomeRepositoryImpl(
    private val factory: HomeFactory
) : HomeRepository {
    override fun discoverMovie(param: HomeParam): Single<HomeEntity> =
        factory.discoverMovie(param.page).map { response ->
            HomeEntity(
                page = response.page ?: -1L,
                totalPages = response.totalPages ?: -1L,
                results = response.results?.map { result ->
                    HomeEntity.Result(
                        title = result.title ?: "Untittled",
                        overView = result.overview ?: "No Description"
                    )
                }?.toMutableList() ?: mutableListOf()
            )
        }

}