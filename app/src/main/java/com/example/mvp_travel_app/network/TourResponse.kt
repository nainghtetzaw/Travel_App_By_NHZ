package com.example.mvp_travel_app.network

import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.data.vos.TourVO
import com.google.gson.annotations.SerializedName

data class TourResponse (
    @SerializedName("code") var code : Int = 0,
    @SerializedName("message") var message : String = "",
    @SerializedName("data") var data : List<TourVO> = listOf()
)