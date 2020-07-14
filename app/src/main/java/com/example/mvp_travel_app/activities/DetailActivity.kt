package com.example.mvp_travel_app.activities

import android.content.Context
import android.content.Intent
import android.content.LocusId
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.mvp_travel_app.R
import com.example.mvp_travel_app.data.models.TravelModel
import com.example.mvp_travel_app.data.models.TravelModelImpl
import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.data.vos.TourVO
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val IE_TRAVEL_ID  = "IE_TRAVEL_ID"
        fun newIntent(context : Context,id: Int) : Intent{
            val intent = Intent(context,DetailActivity::class.java)
                .putExtra(IE_TRAVEL_ID,id)
            return intent
        }
    }

    private val mTravelModel : TravelModel = TravelModelImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra(IE_TRAVEL_ID,0)
        mTravelModel.getCountryById(id).observe(this, Observer {
            if (it != null){
                countryBindData(it)
            }
        })
        mTravelModel.getTourById(id).observe(this, Observer {
            if(it != null){
                tourBindData(it)
            }
        })
    }

    private fun countryBindData(country : CountryVO){
        detailplacename.text = country.name
        Glide.with(this)
            .load(country.photo[2])
            .into(detailimage)
        detaillocation.text = country.location
        detailrating.rating = country.rating
        detaildescrption.text = country.description
    }

    private fun tourBindData(tour : TourVO){
        detailplacename.text = tour.name
        Glide.with(this)
            .load(tour.photo[2])
            .into(detailimage)
        detaillocation.text = tour.location
        detailrating.rating = tour.rating
        detaildescrption.text = tour.description
    }
}