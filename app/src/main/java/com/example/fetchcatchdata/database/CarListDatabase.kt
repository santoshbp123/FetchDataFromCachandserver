package com.example.fetchcatchdata.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fetchcatchdata.util.networkBoundResource

@Database(entities = [CarList::class], version = 1)
abstract class CarListDatabase : RoomDatabase(){
    abstract fun carsDao(): CarsDao



}