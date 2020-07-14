package com.example.mvp_travel_app.mvp.presenters

import android.view.View
import com.example.mvp_travel_app.mvp.views.BaseView

interface BasePresenter<T : BaseView>{
    fun initPresenter(view : T)
}