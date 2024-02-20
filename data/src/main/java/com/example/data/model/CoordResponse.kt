package com.example.data.model

import com.google.gson.annotations.SerializedName

data class CoordResponse(
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("lon")
    val longitude: Double
)