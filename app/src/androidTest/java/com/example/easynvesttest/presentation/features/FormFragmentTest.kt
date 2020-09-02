package com.example.easynvesttest.presentation.features


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.easynvesttest.R
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormFragmentTest {
    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun shouldShowProgressBar() {
        onView(withId(R.id.invested_amount))
            .perform(scrollTo(), typeText("32323.0"))

        onView(withId(R.id.maturity_date))
            .perform(scrollTo(), typeText("03-03-2023"))

        onView(withId(R.id.rate))
            .perform(scrollTo(), typeText("123.00"))

        onView(withId(R.id.simulate))
            .perform(scrollTo(), click())

        onView(withId(R.id.progress)).check(matches(isDisplayed()))
    }
}