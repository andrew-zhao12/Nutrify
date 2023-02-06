package com.cs222.nutrify.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.cs222.nutrify.R
import com.cs222.nutrify.databinding.FragmentUserpreferencesBinding

class UserPreferencesFragment : Fragment() {
    private lateinit var binding: FragmentUserpreferencesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserpreferencesBinding.inflate(inflater, container, false)

        val spinner: Spinner = binding.selectGender
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.gender,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        binding.saveUserPref.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.saveUserPreferencesAction)
        }

        return binding.root
    }
}
