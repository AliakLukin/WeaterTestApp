package com.example.weatertestapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TempLocal(
    val day: Double,
    val eve: Double,
    val max: Double,
    val min: Double,
    val morn: Double,
    val night: Double
): Parcelable
