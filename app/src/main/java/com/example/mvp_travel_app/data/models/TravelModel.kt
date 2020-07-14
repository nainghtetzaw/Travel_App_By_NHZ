package com.example.mvp_travel_app.data.models

import androidx.lifecycle.LiveData
import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.data.vos.TourVO
import com.example.mvp_travel_app.data.vos.TravelVO
import io.reactivex.Observable

interface TravelModel {
    fun getAllDataAndSaveToDatabse()
    fun getCountryData() : LiveData<List<CountryVO>>
    fun getTourData() : LiveData<List<TourVO>>
    fun getCountryById(id : Int) : LiveData<CountryVO>
    fun getTourById(id : Int) : LiveData<TourVO>
}