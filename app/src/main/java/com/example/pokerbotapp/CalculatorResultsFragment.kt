package com.example.pokerbotapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokerbotapp.databinding.FragmentCalculatorResultsBinding



class CalculatorResultsFragment : Fragment() {

    private var _binding : FragmentCalculatorResultsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalculatorResultsBinding.inflate(inflater, container, false)
        val rootView = binding.root

        return rootView
    }
}