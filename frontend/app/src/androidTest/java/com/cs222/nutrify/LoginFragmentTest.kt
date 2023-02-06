package com.cs222.nutrify

import androidx.navigation.findNavController
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cs222.nutrify.ui.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java).onActivity {
            it.findNavController(R.id.nav_host_fragment_container).navigate(R.id.loginFragment)
        }
    }

    @Test
    fun testButtonIsEnabledAndText() {
        onView(withId(R.id.login))
            .check(matches(isEnabled()))

        onView(withId(R.id.login))
            .check(matches(withText(R.string.action_sign_in)))
    }

    @Test
    fun testButtonNavigationIsSuccessful() {
        onView(withId(R.id.login))
            .perform(click())

        onView(withId(R.id.login))
            .check(doesNotExist())
    }
}
