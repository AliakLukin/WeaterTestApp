package com.example.weatertestapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherLocal(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
): Parcelable
