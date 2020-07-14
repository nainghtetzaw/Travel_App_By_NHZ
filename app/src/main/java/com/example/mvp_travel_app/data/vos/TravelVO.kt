package com.example.mvp_travel_app.data.vos

data class TravelVO (
    var country : List<CountryVO> = listOf(),
    var tour : List<TourVO> = listOf()
)