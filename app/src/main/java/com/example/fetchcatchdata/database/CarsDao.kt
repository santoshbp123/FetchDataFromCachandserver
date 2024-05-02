package com.example.fetchcatchdata.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface CarsDao {

    @Query("SELECT * FROM cars")
    fun getAllCars(): Flow<List<CarList>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCars(cars: List<CarList>)


    @Query("DELETE FROM cars")
    suspend fun deleteAllCars()
}
