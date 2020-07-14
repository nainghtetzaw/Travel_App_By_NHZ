package com.example.mvp_travel_app.recyclerview.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.delegates.TravelItemDelegate
import com.google.gson.Gson
import kotlinx.android.synthetic.main.country_item_view.view.*

class CountryViewHolder(itemView : View,delegate: TravelItemDelegate) :BaseCountryViewHolder(itemView) {

    init {
        itemView.setOnClickListener{
            mData?.let {
                delegate.onTapTravelItem(it.id)
            }
        }
    }

    override fun bindData(data: CountryVO) {
        mData = data
        itemView.countryname.text = data.name
        Glide.with(itemView.context)
            .load(data.photo[0])
            .into(itemView.countryimg)
    }
}