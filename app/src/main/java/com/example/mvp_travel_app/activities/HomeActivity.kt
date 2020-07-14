package com.example.mvp_travel_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowId
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvp_travel_app.R
import com.example.mvp_travel_app.data.models.TravelModel
import com.example.mvp_travel_app.data.models.TravelModelImpl
import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.data.vos.TourVO
import com.example.mvp_travel_app.mvp.presenters.MainPresenter
import com.example.mvp_travel_app.mvp.presenters.MainPresenterImpl
import com.example.mvp_travel_app.mvp.views.MainView
import com.example.mvp_travel_app.persistence.db.TravelDB
import com.example.mvp_travel_app.recyclerview.adapters.CountryAdapter
import com.example.mvp_travel_app.recyclerview.adapters.PopularTourAdapter
import com.google.android.material.snackbar.Snackbar
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.empty_view.*

class HomeActivity : AppCompatActivity(),MainView {

    private lateinit var mLinearManager : LinearLayoutManager
    private lateinit var mVerticalManager : LinearLayoutManager
    private lateinit var mCountryAdapter : CountryAdapter
    private lateinit var mPopularTourAdapter : PopularTourAdapter
    private lateinit var mPresenter : MainPresenter
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpViewModel()

        mLinearManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        mVerticalManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        mCountryAdapter = CountryAdapter(mPresenter)
        mPopularTourAdapter = PopularTourAdapter(mPresenter)

        mPresenter.swipeRefresh(this,this)
        setUpRecyclerView()
        onSwipeRefresh()
    }

    override fun onDestroy() {
        super.onDestroy()
        return compositeDisposable.clear()
    }

    override fun enableSwipeRefresh() {
        swiperefreshlayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swiperefreshlayout.isRefreshing = false
    }

    override fun showCountryData(country : MutableList<CountryVO>) {
        mCountryAdapter.setNewData(country)
    }

    override fun showTourData(tour : MutableList<TourVO>) {
        mPopularTourAdapter.setNewData(tour)
    }

    override fun showErrorMessage(message: String) {
        Snackbar.make(window.decorView,message,Snackbar.LENGTH_SHORT).show()
    }

    override fun showEmptyView() {
        emptyimg.visibility = View.VISIBLE
    }

    override fun hideEmptyView(){
        emptyimg.visibility = View.GONE
    }

    override fun navigateToDetailLayout(id: Int) {
        startActivity(DetailActivity.newIntent(this,id))
    }

    private fun setUpRecyclerView(){
        countryreview.layoutManager = mLinearManager
        countryreview.adapter = mCountryAdapter
        populartourreview.layoutManager = mVerticalManager
        populartourreview.adapter = mPopularTourAdapter
    }

    private fun setUpViewModel(){
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun onSwipeRefresh(){
        swiperefreshlayout.setOnRefreshListener{
            mPresenter.swipeRefresh(this,this)
        }
    }
}
