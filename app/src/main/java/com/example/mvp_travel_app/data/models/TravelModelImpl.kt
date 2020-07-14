package com.example.mvp_travel_app.data.models

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.data.vos.TourVO
import com.example.mvp_travel_app.data.vos.TravelVO
import com.example.mvp_travel_app.persistence.db.TravelDB
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class TravelModelImpl(context: Context) : TravelModel , BaseModel(){

    private val mTheDb : TravelDB = TravelDB.getDbInstance(context)

    private fun getCountry() : Observable<List<CountryVO>> {
        return mTravelApi
            .getCountryResponse()
            .map { it.data }
            .subscribeOn(Schedulers.io())
    }

    private fun getTour(): Observable<List<TourVO>>{
        return mTravelApi
            .getTourResponse()
            .map { it.data }
            .subscribeOn(Schedulers.io())
    }

    override fun getAllDataAndSaveToDatabse() {
        val travellist : MutableLiveData<TravelVO> = MutableLiveData()
        Observable.zip<List<CountryVO>,List<TourVO>,TravelVO>(
            getCountry(),
            getTour(),
            BiFunction { country, tour ->
                return@BiFunction TravelVO (country,tour)
            }
        )
            .doOnNext {
                mTheDb.countryDao().insertIntoCountry(it.country)
                mTheDb.tourDao().insertIntoTour(it.tour)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                travellist.postValue(it)
            }
    }

    override fun getCountryData(): LiveData<List<CountryVO>> {
        return mTheDb.countryDao().getAllCountry()
    }

    override fun getTourData(): LiveData<List<TourVO>> {
        return mTheDb.tourDao().getAllTour()
    }

    override fun getCountryById(id: Int): LiveData<CountryVO> {
        return mTheDb.countryDao().getCountryById(id)
    }

    override fun getTourById(id : Int): LiveData<TourVO> {
    return mTheDb.tourDao().getTourById(id)
    }
}