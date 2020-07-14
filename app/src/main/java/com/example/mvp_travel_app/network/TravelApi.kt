package com.example.mvp_travel_app.network

import com.example.mvp_travel_app.utils.GET_ALL_COUNTRY
import com.example.mvp_travel_app.utils.GET_ALL_TOURS
import io.reactivex.Observable
import retrofit2.http.GET

interface TravelApi {
    @GET(GET_ALL_COUNTRY)
    fun getCountryResponse() : Observable<CountryResponse>

    @GET(GET_ALL_TOURS)
    fun getTourResponse() : Observable<TourResponse>
}