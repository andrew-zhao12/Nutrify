package com.cs222.nutrify

import androidx.navigation.findNavController
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cs222.nutrify.ui.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NutritionInputFragmentTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java).onActivity {
            it.findNavController(R.id.nav_host_fragment_container).navigate(R.id.nutritionInputFragment)
        }
    }

    @Test
    fun testAddButtonIsEnabledAndTextExists() {
        onView(withId(R.id.addNutritionInfo))
            .check(matches(isEnabled()))

        onView(withId(R.id.addNutritionInfo))
            .check(matches(withText(R.string.add_food_information)))
    }

    @Test
    fun testSubmitButtonIsEnabledAndTextExists() {
        onView(withId(R.id.submit))
            .check(matches(isEnabled()))

        onView(withId(R.id.submit))
            .check(matches(withText(R.string.submit_nutrition_info)))
    }

    @Test
    fun testMyPreferencesButton() {
        onView(withId(R.id.go_to_user_preferences_from_input))
            .check(matches(isEnabled()))

        onView(withId(R.id.go_to_user_preferences_from_input))
            .perform(click())

        onView(withId(R.id.enter_age))
            .check(matches(withHint(R.string.user_age)))
    }

    @Test
    fun testEditText() {
        onView(withId(R.id.calories))
            .check(matches(withHint(R.string.prompt_calories)))

        onView(withId(R.id.fat))
            .check(matches(withHint(R.string.prompt_fat)))

        onView(withId(R.id.sodium))
            .check(matches(withHint(R.string.prompt_sodium)))

        onView(withId(R.id.carbs))
            .check(matches(withHint(R.string.prompt_carbs)))

        onView(withId(R.id.sugar))
            .check(matches(withHint(R.string.prompt_sugar)))

        onView(withId(R.id.protein))
            .check(matches(withHint(R.string.prompt_protein)))

        onView(withId(R.id.calcium))
            .check(matches(withHint(R.string.prompt_calcium)))

        onView(withId(R.id.iron))
            .check(matches(withHint(R.string.prompt_iron)))

        onView(withId(R.id.potassium))
            .check(matches(withHint(R.string.prompt_potassium)))
    }
}
