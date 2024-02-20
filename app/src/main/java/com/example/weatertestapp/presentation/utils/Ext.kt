package com.example.weatertestapp.presentation.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.weatertestapp.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun ImageView.loadIcon(icon: String?) {
    Glide.with(context)
        .load("https://openweathermap.org/img/wn/${icon}@2x.png")
        .error(R.drawable.ic_empty_weather)
        .placeholder(R.drawable.ic_empty_weather)
        .into(this)
}

fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(text: Int) {
    Toast.makeText(this, getString(text), Toast.LENGTH_SHORT).show()
}

fun Int.convertTimestampToDay(context: Context, fullDate: Boolean): String {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this.toLong() * 1000
    val date = calendar.time

    val dayFormat = SimpleDateFormat(if (fullDate) "EEEE" else "EE", Locale.US)
    val dayOfWeek = dayFormat.format(date)

    val today = Calendar.getInstance()
    return if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
        calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)
    ) {
        context.getString(R.string.today)
    } else {
        dayOfWeek
    }
}

fun Int.convertTimestampToTime(): String {
    val date = Date(this.toLong() * 1000)
    val format = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return format.format(date)
}

fun View.setOnSafeClickListener(listener: (view: View) -> Unit) {
    setOnClickListener(SafeOnClickListener { listener(it) })
}