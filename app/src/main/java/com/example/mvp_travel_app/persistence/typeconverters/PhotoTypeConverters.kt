package com.example.mvp_travel_app.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhotoTypeConverters {

    @TypeConverter
    fun toString(photolist : ArrayList<String>) : String{
        return Gson().toJson(photolist)
    }

    @TypeConverter
    fun toList(photo : String) : ArrayList<String> {
        val photoType = object : TypeToken<ArrayList<String>>(){}.type
        return Gson().fromJson(photo,photoType)
    }
}