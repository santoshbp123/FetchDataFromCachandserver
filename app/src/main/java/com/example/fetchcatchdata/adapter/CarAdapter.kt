package com.example.fetchcatchdata.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchcatchdata.database.CarList
import com.example.fetchcatchdata.databinding.CarListItemsBinding

class CarAdapter : ListAdapter<CarList, CarAdapter.CarViewHolder>(CarListComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding =
            CarListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class CarViewHolder(private val binding: CarListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(carlist: CarList) {
            binding.apply {
                carName.text = carlist.make_and_model
                carTransmission.text = carlist.transmission
                carColor.text = carlist.color
                carDriveType.text = carlist.drive_type
                carFuelType.text = carlist.fuel_type
                carCarType.text = carlist.car_type

            }
        }
    }

    class CarListComparator : DiffUtil.ItemCallback<CarList>() {
        override fun areItemsTheSame(oldItem: CarList, newItem: CarList) =
            oldItem.make_and_model == newItem.make_and_model

        override fun areContentsTheSame(oldItem: CarList, newItem: CarList) =
            oldItem == newItem
    }

}