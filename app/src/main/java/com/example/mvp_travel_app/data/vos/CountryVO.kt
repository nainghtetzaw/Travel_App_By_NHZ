package com.example.mvp_travel_app.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.mvp_travel_app.persistence.typeconverters.PhotoTypeConverters
import com.example.mvp_travel_app.persistence.typeconverters.ScoresAndReviewsTypeConverters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Country")
@TypeConverters(ScoresAndReviewsTypeConverters::class,PhotoTypeConverters::class)
data class CountryVO (
    @PrimaryKey()
    @SerializedName("id") var id : Int = 0,
    @SerializedName("name") var name : String = "",
    @SerializedName("description") var description : String = "",
    @SerializedName("location") var location :  String = "",
    @SerializedName("average_rating") var rating : Float = 0f,
    @SerializedName("photos") var photo : ArrayList<String>  = arrayListOf(),
    @Embedded
    @SerializedName("scores_and_review") var scoresAndReviews : ArrayList<ScoresAndReviewsVO>?= null
)