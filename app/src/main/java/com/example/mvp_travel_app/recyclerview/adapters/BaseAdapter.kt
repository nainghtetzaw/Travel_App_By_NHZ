package com.example.mvp_travel_app.recyclerview.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.mvp_travel_app.recyclerview.viewholders.BaseViewHolder

abstract class BaseAdapter<T : BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {

    var mData : MutableList<W> = mutableListOf()

    override fun getItemCount(): Int {
        return mData.size
    }
    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }
    fun setNewData(data : MutableList<W>){
        mData = data
        notifyDataSetChanged()
    }
    fun addNewData(data : MutableList<W>){
        mData.addAll(data)
        notifyDataSetChanged()
    }
}