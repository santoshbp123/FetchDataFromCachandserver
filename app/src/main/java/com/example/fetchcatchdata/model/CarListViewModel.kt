package com.example.fetchcatchdata.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.fetchcatchdata.repository.CarListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(repository: CarListRepository) : ViewModel(){
    val cars = repository.getCars().asLiveData()
}