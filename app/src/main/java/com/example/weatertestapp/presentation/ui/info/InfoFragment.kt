package com.example.weatertestapp.presentation.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.weatertestapp.databinding.FragmentInfoBinding
import com.example.weatertestapp.model.DayLocal
import com.example.weatertestapp.presentation.utils.convertTimestampToDay
import com.example.weatertestapp.presentation.utils.convertTimestampToTime
import com.example.weatertestapp.presentation.utils.loadIcon

class InfoFragment: Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    private val args: InfoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setInfo(args.dayLocal)
    }

    private fun setInfo(dayLocal: DayLocal) {
        binding.run {
            dateTV.text = dayLocal.dt.convertTimestampToDay(requireContext(), true)
            descriptionTV.text = dayLocal.weather.firstOrNull()?.description
            iconIV.loadIcon(dayLocal.weather.firstOrNull()?.icon)
            dayTemperatureTV.text = dayLocal.temp.day.toString()
            nightTemperatureTV.text = dayLocal.temp.night.toString()
            feelsLikeDayTemperatureTV.text = dayLocal.feelsLike.day.toString()
            feelsLikeNightTemperatureTV.text = dayLocal.feelsLike.night.toString()
            humidityTV.text = dayLocal.humidity.toString()
            pressureTV.text= dayLocal.pressure.toString()
            sunriseTimeTV.text = dayLocal.sunrise.convertTimestampToTime()
            sunsetTimeTV.text= dayLocal.sunset.convertTimestampToTime()
        }
    }
}