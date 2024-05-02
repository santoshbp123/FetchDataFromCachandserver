package com.example.fetchcatchdata.repository

import androidx.room.withTransaction
import com.example.fetchcatchdata.api.CarListAPI
import com.example.fetchcatchdata.database.CarListDatabase
import com.example.fetchcatchdata.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class CarListRepository @Inject constructor(private val api: CarListAPI,
                         private val db: CarListDatabase
) {

    private val carsDao = db.carsDao()

    fun getCars() = networkBoundResource(

        // Query to return the list of all cars
        query = {
            carsDao.getAllCars()
        },

        // Just for testing purpose,
        // a delay of 2 second is set.
        fetch = {
            delay(2000)
            api.getCarList()
        },

        // Save the results in the table.
        // If data exists, then delete it
        // and then store.
        saveFetchResult = { CarList ->
            db.withTransaction {
                carsDao.deleteAllCars()
                carsDao.insertCars(CarList)
            }
        }
    )

    
}