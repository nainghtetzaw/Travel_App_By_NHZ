package com.example.mvp_travel_app.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvp_travel_app.data.getDummyCountryData
import com.example.mvp_travel_app.data.getDummyTourData
import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.data.vos.TourVO

object MockTravelModelImpl : TravelModel {

    override fun getAllDataAndSaveToDatabse() {
        val countryData = MutableLiveData<List<CountryVO>>()
        countryData.postValue(getDummyCountryData())
        val tourData = MutableLiveData<List<TourVO>>()
        tourData.postValue(getDummyTourData())
    }

    override fun getCountryData(): LiveData<List<CountryVO>> {
        val countryData = MutableLiveData<List<CountryVO>>()
        countryData.postValue(getDummyCountryData())
        return countryData
    }

    override fun getTourData(): LiveData<List<TourVO>> {
        val tourData = MutableLiveData<List<TourVO>>()
        tourData.postValue(getDummyTourData())
        return tourData
    }

    override fun getCountryById(id: Int): LiveData<CountryVO> {
        val countryData = MutableLiveData<CountryVO>()
        countryData.postValue(getDummyCountryData().first{it.id == id})
        return countryData
    }

    override fun getTourById(id: Int): LiveData<TourVO> {
        val tourData = MutableLiveData<TourVO>()
        tourData.postValue(getDummyTourData().first{it.id == id})
        return tourData
    }
}