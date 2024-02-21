package com.example.weatertestapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LatLongLocal(
    val lat: Double,
    val lon: Double
): Parcelable
