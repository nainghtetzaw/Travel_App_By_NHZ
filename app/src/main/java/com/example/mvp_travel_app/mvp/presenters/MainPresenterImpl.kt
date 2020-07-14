package com.example.mvp_travel_app.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.mvp_travel_app.data.models.TravelModel
import com.example.mvp_travel_app.data.models.TravelModelImpl
import com.example.mvp_travel_app.mvp.views.MainView

class MainPresenterImpl : MainPresenter,AbstractPresenter<MainView>() {

    lateinit var mModel : TravelModel

    override fun swipeRefresh(lifecycleOwner: LifecycleOwner,context: Context) {
        mModel = TravelModelImpl(context)
        requestData(lifecycleOwner)
    }

    override fun onTapTravelItem(id : Int) {
        mView?.navigateToDetailLayout(id)
    }

    private fun requestData(lifecycleOwner: LifecycleOwner) {
        mView?.enableSwipeRefresh()
        mView?.hideEmptyView()
        mModel.getCountryData ().observe(lifecycleOwner, Observer {
            if(it.isNotEmpty()){
                mView?.disableSwipeRefresh()
                mView?.hideEmptyView()
                mView?.showCountryData(it.toMutableList())
            }else{
                mView?.showEmptyView()
                mView?.showErrorMessage("No Data")
            }
        })
        mModel.getTourData ().observe(lifecycleOwner, Observer {
            if(it.isNotEmpty()){
                mView?.disableSwipeRefresh()
                mView?.hideEmptyView()
                mView?.showTourData(it.toMutableList())
            }else{
                mView?.showEmptyView()
                mView?.showErrorMessage("No Data")
            }
        })
    }
}