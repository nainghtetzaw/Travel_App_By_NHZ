package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mvp_travel_app.activities.HomeActivity
import com.example.mvp_travel_app.data.getDummyCountryData
import com.example.mvp_travel_app.data.getDummyTourData
import com.example.mvp_travel_app.data.models.MockTravelModelImpl
import com.example.mvp_travel_app.data.models.TravelModel
import com.example.mvp_travel_app.data.models.TravelModelImpl
import com.example.mvp_travel_app.data.vos.CountryVO
import com.example.mvp_travel_app.mvp.presenters.MainPresenterImpl
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class MainPresenterImplTest  {

    private lateinit var mPresenter : MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView : HomeActivity

    private lateinit var mModel : TravelModel

    @Before
    fun setUp(){

        MockKAnnotations.init(this)

        TravelModelImpl(ApplicationProvider.getApplicationContext())
        mModel = MockTravelModelImpl

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mModel = this.mModel
    }

    @Test
    fun onTapCountryItem_navigateToNewsDetailScreen() {
        val countryList = CountryVO()
        countryList.name = "Myanmar"
        countryList.description  = "Its a good place"
        countryList.location = "At Southeast Asia"
        countryList.rating = 5.0f

        mPresenter.onTapTravelItem(countryList.id)
        verify {
            mView.navigateToDetailLayout(countryList.id)
        }
    }

    @Test
    fun onUiReady_ShowCountryList(){
        val lifecycleowner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleowner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleowner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.swipeRefresh(lifecycleowner,ApplicationProvider.getApplicationContext())

        verify {
            mView.showCountryData(getDummyCountryData().toMutableList())
            mView.showTourData(getDummyTourData().toMutableList())
        }
    }
}