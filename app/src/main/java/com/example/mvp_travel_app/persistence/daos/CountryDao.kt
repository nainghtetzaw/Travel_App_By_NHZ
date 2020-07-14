package com.example.mvp_travel_app.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.data.vos.TourVO

@Dao
interface CountryDao {

    @Query("SELECT * FROM Country")
    fun getAllCountry() : LiveData<List<CountryVO>>

    @Query("SELECT * FROM Country WHERE name = :countryid")
    fun getCountryById(countryid : Int) : LiveData<CountryVO>

    @Insert
    fun insertIntoCountry(country : List<CountryVO>)

}