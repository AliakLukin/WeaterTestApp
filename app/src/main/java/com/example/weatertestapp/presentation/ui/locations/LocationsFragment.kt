package com.example.weatertestapp.presentation.ui.locations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatertestapp.R
import com.example.weatertestapp.databinding.FragmentLocationsBinding
import com.example.weatertestapp.model.LatLongLocal
import com.example.weatertestapp.presentation.ui.locations.adapter.LocationAdapter
import com.example.weatertestapp.presentation.ui.locations.adapter.OnDeleteLocationClicked
import com.example.weatertestapp.presentation.ui.locations.adapter.OnLocationClicked
import com.example.weatertestapp.presentation.ui.main.MainActivity
import com.example.weatertestapp.presentation.utils.showToast
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsFragment : Fragment(), OnLocationClicked, OnDeleteLocationClicked {

    private var _binding: FragmentLocationsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LocationsViewModel by viewModel()
    private lateinit var adapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getLocations()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAutocompleteFragment()
        initRV()
        initViewModel()
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).showBottomNavigation()
    }

    private fun initRV() {
        binding.locationsRV.layoutManager = LinearLayoutManager(requireContext())
        adapter =
            LocationAdapter(
                this@LocationsFragment,
                this@LocationsFragment
            )
        binding.locationsRV.adapter = adapter
        binding.locationsRV.isNestedScrollingEnabled = false
    }

    private fun initViewModel() {
        viewModel.errorOnSave.observe(viewLifecycleOwner) { error ->
            if (error) requireContext().showToast(R.string.error_select_place)
        }

        viewModel.locations.observe(viewLifecycleOwner) { list ->
            adapter.data = list
        }
    }

    private fun initAutocompleteFragment() {
        val autocompleteFragment =
            childFragmentManager.findFragmentById(R.id.autocomplete_fragment)
                    as AutocompleteSupportFragment

        autocompleteFragment.setPlaceFields(listOf(Place.Field.LAT_LNG, Place.Field.NAME))

        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                viewModel.saveLocation(place.name, place.latLng?.latitude, place.latLng?.longitude)
            }

            override fun onError(status: Status) {
                requireContext().showToast(R.string.error_select_place)
            }
        })
    }

    override fun onClicked(latitude: Double, longitude: Double) {
        val action =
            LocationsFragmentDirections.actionOpenLocationInfo(LatLongLocal(latitude, longitude))
        findNavController().navigate(action)
        (requireActivity() as MainActivity).hideBottomNavigation()
    }

    override fun onDelete(id: String) {
        viewModel.delete(id)
    }
}