package com.example.mvp_travel_app.mvp.presenters.uitests

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.mvp_travel_app.R
import com.example.mvp_travel_app.activities.HomeActivity
import com.example.mvp_travel_app.recyclerview.viewholders.CountryViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class NavigateToTravelDetailScreen {

    private val activityTestRule = ActivityTestRule<HomeActivity>(HomeActivity::class.java)

    @Before
    fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun onTapCountryItem_NavigateToDetailScreen(){
        onView(withId(R.id.countryreview))
            .perform(RecyclerViewActions.actionOnItemAtPosition<CountryViewHolder>(0,click()))

        onView(withId(R.id.btnback))
            .check(matches(isDisplayed()))
    }
}