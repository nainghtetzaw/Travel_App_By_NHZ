package com.example.mvp_travel_app.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mvp_travel_app.R
import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.delegates.TravelItemDelegate
import com.example.mvp_travel_app.recyclerview.viewholders.BaseCountryViewHolder
import com.example.mvp_travel_app.recyclerview.viewholders.CountryViewHolder

class CountryAdapter(delegate: TravelItemDelegate) : BaseAdapter<BaseCountryViewHolder,CountryVO>(){

    private val mDelegate : TravelItemDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseCountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item_view,parent,false)
        return CountryViewHolder(view,mDelegate)
    }
}