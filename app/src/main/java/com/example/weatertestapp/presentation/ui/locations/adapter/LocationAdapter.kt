package com.example.weatertestapp.presentation.ui.locations.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatertestapp.databinding.ItemLocationBinding
import com.example.weatertestapp.model.LocationLocal

class LocationAdapter(
    private val listener: OnLocationClicked,
    private val deleteListener: OnDeleteLocationClicked
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: List<LocationLocal> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            listener,
            deleteListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as LocationViewHolder).bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}