package com.rikko.moviecatalogue

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Movie(
    val page: Int,
    val result: List<Result>,
    val total_page: Int,
    val total_result: Int
)

