package com.example.weatertestapp.presentation.ui.home.adapter

import com.example.weatertestapp.model.DayLocal

interface OnWeatherItemClicked {
    fun onClicked(dayLocal: DayLocal)
}