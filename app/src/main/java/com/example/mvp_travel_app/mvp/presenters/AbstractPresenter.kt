package com.example.mvp_travel_app.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.mvp_travel_app.mvp.views.BaseView

abstract class AbstractPresenter<T : BaseView> : BasePresenter<T>,ViewModel(){

    var mView : T? = null

    override fun initPresenter(view: T) {
        mView = view
    }

}