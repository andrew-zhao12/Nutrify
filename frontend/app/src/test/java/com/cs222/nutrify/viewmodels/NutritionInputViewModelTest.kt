
package com.cs222.nutrify.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cs222.nutrify.models.NutritionInformation
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NutritionInputViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: NutritionInputViewModel

    @Before
    fun setup() {
        viewModel = NutritionInputViewModel()
    }

    @Test
    fun testAddNutritionInformation() {
        val expectedNutritionInformation = NutritionInformation(
            1.2, 3.4, 5.6,
            7.8, 9.11, 12.13, 14.15, 16.17, 18.19
        )
        viewModel.calories.value = "1.2"
        viewModel.fat.value = "3.4"
        viewModel.sodium.value = "5.6"
        viewModel.carbs.value = "7.8"
        viewModel.sugar.value = "9.11"
        viewModel.protein.value = "12.13"
        viewModel.calcium.value = "14.15"
        viewModel.iron.value = "16.17"
        viewModel.potassium.value = "18.19"
        viewModel.addNutritionInformation()
        Assert.assertEquals(1, viewModel.getNutritionInformationList().size)
        Assert.assertEquals(expectedNutritionInformation, viewModel.getNutritionInformationList()[0])
    }
    @Test
    fun testUndoPrevious() {
        viewModel.calories.value = "1.2"
        viewModel.fat.value = "3.4"
        viewModel.sodium.value = "5.6"
        viewModel.carbs.value = "7.8"
        viewModel.sugar.value = "9.11"
        viewModel.protein.value = "12.13"
        viewModel.calcium.value = "14.15"
        viewModel.iron.value = "16.17"
        viewModel.potassium.value = "18.19"
        viewModel.addNutritionInformation()
        // Setting to empty string to imitate what happens when the user submits nutrition info
        viewModel.calories.value = ""
        viewModel.fat.value = ""
        viewModel.sodium.value = ""
        viewModel.carbs.value = ""
        viewModel.sugar.value = ""
        viewModel.protein.value = ""
        viewModel.calcium.value = ""
        viewModel.iron.value = ""
        viewModel.potassium.value = ""
        viewModel.undoPreviousAddition()
        Assert.assertTrue(viewModel.getNutritionInformationList().isEmpty())
        Assert.assertEquals("1.2", viewModel.calories.value)
        Assert.assertEquals("3.4", viewModel.fat.value)
        Assert.assertEquals("5.6", viewModel.sodium.value)
        Assert.assertEquals("7.8", viewModel.carbs.value)
        Assert.assertEquals("9.11", viewModel.sugar.value)
        Assert.assertEquals("12.13", viewModel.protein.value)
        Assert.assertEquals("14.15", viewModel.calcium.value)
        Assert.assertEquals("16.17", viewModel.iron.value)
        Assert.assertEquals("18.19", viewModel.potassium.value)
    }
}
