package com.example.mvp_travel_app.data

import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.data.vos.TourVO

fun getDummyCountryData() : List<CountryVO>{
    val countryList = CountryVO()
    countryList.name = "Myanmar"
    countryList.description  = "Its a good place"
    countryList.location = "At Southeast Asia"
    countryList.rating = 5.0f

    return listOf(countryList)
}

fun getDummyTourData() : List<TourVO>{
    val tourList = TourVO()
    tourList.name = "Popa"
    tourList.description = "Its a great place"
    tourList.location = "At Myanmar"
    tourList.rating = 5.0f

    return listOf(tourList)
}