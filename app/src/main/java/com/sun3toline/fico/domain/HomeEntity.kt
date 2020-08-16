package com.sun3toline.fico.domain


data class HomeEntity(
    val page: Long,
    val totalPages: Long,
    val results: MutableList<Result>
) {
    data class Result(
        val title: String,
        val overView: String
    )
}