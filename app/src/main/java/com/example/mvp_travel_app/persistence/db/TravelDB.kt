package com.example.mvp_travel_app.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.data.vos.TourVO
import com.example.mvp_travel_app.persistence.daos.CountryDao
import com.example.mvp_travel_app.persistence.daos.TourDao

@Database(entities = [CountryVO::class,TourVO::class],version = 12,exportSchema = false)
abstract class TravelDB: RoomDatabase() {
    companion object{

        val DB_NAME : String = "Travel_Database"
        var dbInstance : TravelDB? = null

        fun getDbInstance(context : Context): TravelDB{
            when(dbInstance){
                null-> {
                    dbInstance = Room.databaseBuilder(context,TravelDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return dbInstance!!
        }
    }
    abstract fun countryDao() : CountryDao
    abstract fun tourDao() : TourDao
}