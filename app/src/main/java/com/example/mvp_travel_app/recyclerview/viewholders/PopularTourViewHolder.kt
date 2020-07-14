package com.example.mvp_travel_app.recyclerview.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.mvp_travel_app.data.vos.TourVO
import com.example.mvp_travel_app.delegates.TravelItemDelegate
import kotlinx.android.synthetic.main.popular_tour_item_view.view.*

class PopularTourViewHolder(itemView : View,delegate: TravelItemDelegate) : BaseTourViewHolder(itemView) {

    init {
        itemView.setOnClickListener{
            mData?.let {
                delegate.onTapTravelItem(it.id)
            }
        }
    }

    override fun bindData(data: TourVO) {
        mData = data
        itemView.tv_popular_tours_name.text = data.name
        Glide.with(itemView.context)
            .load(data.photo[0])
            .into(itemView.tourimg )
    }
}