package com.cs222.nutrify.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.cs222.nutrify.R
import com.cs222.nutrify.databinding.FragmentNutritioninputBinding
import com.cs222.nutrify.viewmodels.NutritionInputViewModel

class NutritionInputFragment : Fragment() {

    private lateinit var binding: FragmentNutritioninputBinding
    private val viewModel: NutritionInputViewModel by activityViewModels {
        NutritionInputViewModel.Factory
    }
    private lateinit var editTextList: List<EditText>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNutritioninputBinding.inflate(inflater, container, false)
        editTextList = listOf(
            binding.calories, binding.fat, binding.sodium, binding.carbs,
            binding.sugar, binding.protein, binding.calcium, binding.iron, binding.potassium
        )
        setButtonListeners()
        setCalorieObservers()
        setFatObservers()
        setSodiumObservers()
        setCarbsObservers()
        setSugarObservers()
        setProteinObservers()
        setCalciumObservers()
        setIronObservers()
        setPotassiumObservers()
        return binding.root
    }

    private fun setButtonListeners() {
        binding.addNutritionInfo.setOnClickListener {
            val listOfNutritionValues = editTextList.map {
                try {
                    it.text.toString().toDouble()
                } catch (e: NumberFormatException) {
                    null
                }
            }
            if (listOfNutritionValues.contains(null)) {
                Toast.makeText(activity, R.string.unfilled_text_boxes_add, Toast.LENGTH_SHORT).show()
            } else {
                viewModel.addNutritionInformation()
                editTextList.forEach { it.text.clear() }
                Toast.makeText(activity, R.string.filled_text_boxes_add, Toast.LENGTH_SHORT).show()
            }
        }

        binding.goToUserPreferencesFromInput.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.updateUserPreferencesAction)
        }

        binding.undoPreviousNutritionInfo.setOnClickListener {
            if (viewModel.getNutritionInformationList().isEmpty()) {
                Toast.makeText(activity, R.string.no_previous_items_exist, Toast.LENGTH_SHORT).show()
            } else {
                viewModel.undoPreviousAddition()
                Toast.makeText(activity, R.string.previous_item_exists, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setCalorieObservers() {
        val caloriesObserver = Observer<String> {
            if (binding.calories.text.toString() != it) binding.calories.setText(it)
        }
        viewModel.calories.observe(viewLifecycleOwner, caloriesObserver)

        binding.calories.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun afterTextChanged(s: Editable?) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.calories.value = s.toString()
            }
        })
    }

    private fun setFatObservers() {
        val fatObserver = Observer<String> {
            if (binding.fat.text.toString() != it) binding.fat.setText(it)
        }
        viewModel.fat.observe(viewLifecycleOwner, fatObserver)

        binding.fat.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun afterTextChanged(s: Editable?) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.fat.value = s.toString()
            }
        })
    }

    private fun setSodiumObservers() {
        val sodiumObserver = Observer<String> {
            if (binding.sodium.text.toString() != it) binding.sodium.setText(it)
        }
        viewModel.sodium.observe(viewLifecycleOwner, sodiumObserver)

        binding.sodium.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun afterTextChanged(s: Editable?) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.sodium.value = s.toString()
            }
        })
    }

    private fun setCarbsObservers() {
        val carbsObserver = Observer<String> {
            if (binding.carbs.text.toString() != it) binding.carbs.setText(it)
        }
        viewModel.carbs.observe(viewLifecycleOwner, carbsObserver)

        binding.carbs.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun afterTextChanged(s: Editable?) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.carbs.value = s.toString()
            }
        })
    }

    private fun setSugarObservers() {
        val sugarObserver = Observer<String> {
            if (binding.sugar.text.toString() != it) binding.sugar.setText(it)
        }
        viewModel.sugar.observe(viewLifecycleOwner, sugarObserver)

        binding.sugar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun afterTextChanged(s: Editable?) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.sugar.value = s.toString()
            }
        })
    }

    private fun setProteinObservers() {
        val proteinObserver = Observer<String> {
            if (binding.protein.text.toString() != it) binding.protein.setText(it)
        }
        viewModel.protein.observe(viewLifecycleOwner, proteinObserver)

        binding.protein.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun afterTextChanged(s: Editable?) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.protein.value = s.toString()
            }
        })
    }

    private fun setCalciumObservers() {
        val calciumObserver = Observer<String> {
            if (binding.calcium.text.toString() != it) binding.calcium.setText(it)
        }
        viewModel.calcium.observe(viewLifecycleOwner, calciumObserver)

        binding.calcium.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun afterTextChanged(s: Editable?) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.calcium.value = s.toString()
            }
        })
    }

    private fun setIronObservers() {
        val ironObserver = Observer<String> {
            if (binding.iron.text.toString() != it) binding.iron.setText(it)
        }
        viewModel.iron.observe(viewLifecycleOwner, ironObserver)

        binding.iron.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun afterTextChanged(s: Editable?) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.iron.value = s.toString()
            }
        })
    }

    private fun setPotassiumObservers() {
        val potassiumObserver = Observer<String> {
            if (binding.potassium.text.toString() != it) binding.potassium.setText(it)
        }
        viewModel.potassium.observe(viewLifecycleOwner, potassiumObserver)

        binding.potassium.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun afterTextChanged(s: Editable?) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.potassium.value = s.toString()
            }
        })
    }
}
