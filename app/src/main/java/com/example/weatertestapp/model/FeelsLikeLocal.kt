package com.example.weatertestapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeelsLikeLocal(
    val day: Double,
    val eve: Double,
    val morn: Double,
    val night: Double
): Parcelable
