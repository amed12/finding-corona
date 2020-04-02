package com.sun3toline.fico.data.network

import com.sun3toline.fico.data.network.models.CountryResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CountryDataSource {
    @GET("/summary")
    fun getSummary(): Single<CountryResponse>

}