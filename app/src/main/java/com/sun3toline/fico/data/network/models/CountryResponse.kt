package com.sun3toline.fico.data.network.models


import com.google.gson.annotations.SerializedName

data class CountryResponse(
    @SerializedName("Countries")
    val countries: List<Country>,
    @SerializedName("Date")
    val date: String // 2020-03-29T02:07:26.174102617Z
) {
    data class Country(
        @SerializedName("Country")
        val country: String, // Zimbabwe
        @SerializedName("NewConfirmed")
        val newConfirmed: Int, // 2
        @SerializedName("NewDeaths")
        val newDeaths: Int, // 0
        @SerializedName("NewRecovered")
        val newRecovered: Int, // 0
        @SerializedName("Slug")
        val slug: String, // zimbabwe
        @SerializedName("TotalConfirmed")
        val totalConfirmed: Int, // 7
        @SerializedName("TotalDeaths")
        val totalDeaths: Int, // 1
        @SerializedName("TotalRecovered")
        val totalRecovered: Int // 0
    )
}