package com.example.mvp_travel_app.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.mvp_travel_app.data.vos.ScoresAndReviewsVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ScoresAndReviewsTypeConverters {

    @TypeConverter
    fun toString(scoreandreviews : ArrayList<ScoresAndReviewsVO>) : String {
        return Gson().toJson(scoreandreviews)
    }

    @TypeConverter
    fun toArraylist(scoresandreviews : String) : ArrayList<ScoresAndReviewsVO> {
        val scoresandreviewstype = object : TypeToken<ArrayList<ScoresAndReviewsVO>>(){}.type
        return Gson().fromJson(scoresandreviews,scoresandreviewstype)
    }
}