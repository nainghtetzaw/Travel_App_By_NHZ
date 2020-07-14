package com.example.mvp_travel_app.data.vos

import com.google.gson.annotations.SerializedName

data class ScoresAndReviewsVO (
    @SerializedName("name") var name : String = "",
    @SerializedName("scores") var scores : Float = 0f,
    @SerializedName("max_scores") var maxScores : Int = 0,
    @SerializedName("total_reviews") var totalReviews : Int = 0
)