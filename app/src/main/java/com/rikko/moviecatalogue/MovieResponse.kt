package com.rikko.moviecatalogue

import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("results")
    val result : List<Result>
)
