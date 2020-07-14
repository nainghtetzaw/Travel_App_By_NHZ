package com.example.mvp_travel_app.recyclerview.viewholders

import android.view.View
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder <T>(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var mData : T? = null

    abstract fun bindData(data : T)
}