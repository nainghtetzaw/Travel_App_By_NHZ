package com.example.mvp_travel_app.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.mvp_travel_app.delegates.TravelItemDelegate
import com.example.mvp_travel_app.mvp.views.MainView

interface MainPresenter : TravelItemDelegate,BasePresenter<MainView> {
    fun swipeRefresh(lifecycleOwner: LifecycleOwner,context: Context)
}