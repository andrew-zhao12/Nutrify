package com.cs222.nutrify.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cs222.nutrify.models.NutritionInformation

class NutritionInputViewModel : ViewModel() {

    private val nutritionInformationList: MutableList<NutritionInformation> = mutableListOf()

    val calories: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val fat: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val sodium: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val carbs: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val sugar: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val protein: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val calcium: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val iron: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val potassium: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                NutritionInputViewModel()
            }
        }
    }

    fun addNutritionInformation() {
        val nutritionInformation = NutritionInformation()
        nutritionInformation.calories = calories.value?.toDouble()
        nutritionInformation.fat = fat.value?.toDouble()
        nutritionInformation.sodium = sodium.value?.toDouble()
        nutritionInformation.carbs = carbs.value?.toDouble()
        nutritionInformation.sugar = sugar.value?.toDouble()
        nutritionInformation.protein = protein.value?.toDouble()
        nutritionInformation.calcium = calcium.value?.toDouble()
        nutritionInformation.iron = iron.value?.toDouble()
        nutritionInformation.potassium = potassium.value?.toDouble()
        nutritionInformationList.add(nutritionInformation)
    }

    fun undoPreviousAddition() {
        val previousInfo: NutritionInformation = nutritionInformationList.removeLast()
        calories.value = previousInfo.calories.toString()
        fat.value = previousInfo.fat.toString()
        sodium.value = previousInfo.sodium.toString()
        carbs.value = previousInfo.carbs.toString()
        sugar.value = previousInfo.sugar.toString()
        protein.value = previousInfo.protein.toString()
        calcium.value = previousInfo.calcium.toString()
        iron.value = previousInfo.iron.toString()
        potassium.value = previousInfo.potassium.toString()
    }

    fun getNutritionInformationList(): List<NutritionInformation> = nutritionInformationList
}
