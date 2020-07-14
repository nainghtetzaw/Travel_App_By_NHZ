package com.example.mvp_travel_app.mvp.presenters.imstrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.mvp_travel_app.data.getDummyCountryData
import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.persistence.daos.CountryDao
import com.example.mvp_travel_app.persistence.daos.TourDao
import com.example.mvp_travel_app.persistence.db.TravelDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {

    private lateinit var db : TravelDB
    private lateinit var countryDao : CountryDao
    private lateinit var tourDao: TourDao

    @Before
    fun setUpDatabase(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, TravelDB::class.java).build()
        countryDao = db.countryDao()
        tourDao = db.tourDao()
    }

    @After
    fun closeDatabase(){
        db.close()
    }

    @Test
    fun InsertCountryDataIntoDatabase(){
        countryDao.insertIntoCountry(getDummyCountryData())
        assert(countryDao.getCountryById(0).value?.id == 0)
    }
}