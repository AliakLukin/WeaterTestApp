package com.example.weatertestapp.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Day
import com.example.weatertestapp.databinding.ItemWeatherWithDateBinding
import com.example.weatertestapp.model.DayLocal

class WeatherAdapter(
    private val listener: OnWeatherItemClicked
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: List<DayLocal> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return WeatherViewHolder(
            ItemWeatherWithDateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            listener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as WeatherViewHolder).bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}