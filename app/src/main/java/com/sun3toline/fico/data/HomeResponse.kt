package com.sun3toline.fico.data


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class HomeResponse(
    @SerializedName("page")
    val page: Long? = -1L, // 1
    @SerializedName("results")
    val results: List<Result>? = emptyList(),
    @SerializedName("total_pages")
    val totalPages: Long? = -1L
) {
    @Keep
    data class Result(
        @SerializedName("overview")
        val overview: String? = null,
        @SerializedName("title")
        val title: String? = null
    )
}