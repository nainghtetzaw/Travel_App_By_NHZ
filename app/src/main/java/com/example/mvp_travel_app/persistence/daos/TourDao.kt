package com.example.mvp_travel_app.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvp_travel_app.data.vos.TourVO

@Dao
interface TourDao {

    @Query("SELECT * FROM Tour")
    fun getAllTour() : LiveData<List<TourVO>>

    @Query("SELECT * FROM Tour where name = :tourid")
    fun getTourById(tourid : Int) : LiveData<TourVO>

    @Insert
    fun insertIntoTour(tour : List<TourVO>)
}