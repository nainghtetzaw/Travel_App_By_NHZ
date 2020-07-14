package com.example.mvp_travel_app.mvp.views

import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.data.vos.TourVO
import java.util.*

interface MainView : BaseView{
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun showCountryData(country : MutableList<CountryVO>)
    fun showTourData(tour : MutableList<TourVO>)
    fun showErrorMessage(message : String)
    fun showEmptyView()
    fun hideEmptyView()
    fun navigateToDetailLayout(id : Int)
}