package com.example.weatertestapp.presentation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.CurrentForecast
import com.example.weatertestapp.BuildConfig
import com.example.weatertestapp.databinding.FragmentHomeBinding
import com.example.weatertestapp.model.DayLocal
import com.example.weatertestapp.presentation.ui.home.adapter.OnWeatherItemClicked
import com.example.weatertestapp.presentation.ui.home.adapter.WeatherAdapter
import com.example.weatertestapp.presentation.ui.main.MainActivity
import com.example.weatertestapp.presentation.utils.loadIcon
import com.google.android.libraries.places.api.Places
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment: Fragment(), OnWeatherItemClicked {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by sharedViewModel()
    private lateinit var adapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!Places.isInitialized()) {
            Places.initialize(requireContext(), BuildConfig.PLACES_API_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initRV()
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).showBottomNavigation()
    }

    private fun initRV() {
        binding.weatherRV.layoutManager = LinearLayoutManager(requireContext())
        adapter =
            WeatherAdapter(
                this@HomeFragment,
            )
        binding.weatherRV.adapter = adapter
        binding.weatherRV.isNestedScrollingEnabled = false
    }

    private fun initViewModel() {
        viewModel.currentForecast.observe(viewLifecycleOwner) { forecast ->
            forecast?.let {
               setWeatherInfo(it)
            }
        }

        viewModel.weeklyForecast.observe(viewLifecycleOwner) { forecast ->
            forecast?.let {
                adapter.data = it
            }
        }

        viewModel.latLongLocal.observe(viewLifecycleOwner) { latLang ->
            viewModel.getCurrentWeather(latLang.lat, latLang.lon)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.run {
                weatherInfoV.isVisible = !it
                weatherRV.isVisible = !it
            }
        }
    }

    private fun setWeatherInfo(currentForecast: CurrentForecast) {
        binding.weatherInfoV.setUpView(currentForecast)
    }

    override fun onClicked(dayLocal: DayLocal) {
        val action = HomeFragmentDirections.actionOpenInfo(dayLocal)
        findNavController().navigate(action)
        (requireActivity() as MainActivity).hideBottomNavigation()
    }
}