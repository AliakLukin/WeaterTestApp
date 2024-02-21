package com.example.weatertestapp.presentation.ui.locationinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatertestapp.databinding.FragmentLocationInfoBinding
import com.example.weatertestapp.model.DayLocal
import com.example.weatertestapp.presentation.ui.home.adapter.OnWeatherItemClicked
import com.example.weatertestapp.presentation.ui.home.adapter.WeatherAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationInfoFragment : Fragment(), OnWeatherItemClicked {

    private var _binding: FragmentLocationInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LocationInfoViewModel by viewModel()
    private lateinit var adapter: WeatherAdapter
    private val args: LocationInfoFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getWeeklyForecast(args.latLonLocal.lat, args.latLonLocal.lon)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationInfoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initRV()
    }

    private fun initRV() {
        binding.weatherRV.layoutManager = LinearLayoutManager(requireContext())
        adapter =
            WeatherAdapter(
                this@LocationInfoFragment,
            )
        binding.weatherRV.adapter = adapter
        binding.weatherRV.isNestedScrollingEnabled = false
    }

    private fun initViewModel() {
        viewModel.weeklyForecast.observe(viewLifecycleOwner) { forecast ->
            forecast?.let { pair ->
                binding.cityTV.text = pair.first
                adapter.data = pair.second
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.run {
                cityTV.isVisible = !it
                weatherRV.isVisible = !it
            }
        }
    }

    override fun onClicked(dayLocal: DayLocal) {
        val action = LocationInfoFragmentDirections.actionOpenInfo(dayLocal)
        findNavController().navigate(action)
    }
}