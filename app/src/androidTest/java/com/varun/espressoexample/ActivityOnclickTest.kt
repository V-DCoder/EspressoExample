package com.varun.espressoexample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class ActivityOnclickTest {

  @get:Rule
  var activityRule : ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

  @Test
  fun textTransfetTest()
  {
    onView(ViewMatchers.withId(R.id.editText))
      .perform(typeText("abcd"))

    onView(ViewMatchers.withId(R.id.submitBtn)).perform(click())

    onView(withId(R.id.tv)).check(ViewAssertions.matches(withText("abcd")))
  }
}