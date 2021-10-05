package com.dev2061.mvvmtictactoe

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dev2061.mvvmtictactoe.view.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @Rule
    @JvmField
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkWinnerDiagonal() {

        onView(withId(R.id.s02)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.s12)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.s11)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.s22)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.s20)).perform(ViewActions.click())

        onView(ViewMatchers.withText("X won"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
