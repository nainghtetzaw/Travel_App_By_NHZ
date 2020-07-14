package com.example.mvp_travel_app.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp_travel_app.R
import com.example.mvp_travel_app.data.vos.TourVO
import com.example.mvp_travel_app.delegates.TravelItemDelegate
import com.example.mvp_travel_app.recyclerview.viewholders.BaseTourViewHolder
import com.example.mvp_travel_app.recyclerview.viewholders.PopularTourViewHolder

class PopularTourAdapter(delegate: TravelItemDelegate) : BaseAdapter<BaseTourViewHolder,TourVO>() {

    private val mDelegate :  TravelItemDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseTourViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_tour_item_view,parent,false)
        return PopularTourViewHolder(view,mDelegate)
    }
}