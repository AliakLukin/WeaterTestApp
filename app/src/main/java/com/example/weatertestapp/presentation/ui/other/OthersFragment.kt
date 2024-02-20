package com.example.weatertestapp.presentation.ui.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatertestapp.R
import com.example.weatertestapp.databinding.FragmentOthersBinding
import com.example.weatertestapp.presentation.utils.showToast
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener

class OthersFragment: Fragment() {

    private var _binding: FragmentOthersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOthersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAutocompleteFragment()
    }

    private fun initAutocompleteFragment() {
        val autocompleteFragment =
            childFragmentManager.findFragmentById(R.id.autocomplete_fragment)
                    as AutocompleteSupportFragment

        autocompleteFragment.setPlaceFields(listOf(Place.Field.LAT_LNG, Place.Field.NAME))

        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                place.latLng?.let { latLon ->
//                    viewModel.getForecast(latLon.latitude, latLon.longitude)
                } ?: requireContext().showToast(R.string.error_select_place)
            }

            override fun onError(status: Status) {
                requireContext().showToast(R.string.error_select_place)
            }
        })
    }
}