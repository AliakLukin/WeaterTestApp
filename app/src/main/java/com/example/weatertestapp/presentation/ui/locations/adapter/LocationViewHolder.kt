package com.example.weatertestapp.presentation.ui.locations.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.weatertestapp.databinding.ItemLocationBinding
import com.example.weatertestapp.model.LocationLocal
import com.example.weatertestapp.presentation.utils.setOnSafeClickListener

open class LocationViewHolder (
    private val binding: ItemLocationBinding,
    private val listener: OnLocationClicked,
    private val deleteListener: OnDeleteLocationClicked
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(local: LocationLocal) {
        binding.run {
            nameTV.text = local.name
            root.setOnSafeClickListener {
                listener.onClicked(local.latitude, local.longitude)
            }
            deleteIV.setOnSafeClickListener {
                deleteListener.onDelete(local.id)
            }
        }
    }
}