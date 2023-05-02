package com.example.pokerbotapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.pokerbotapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.calculatorModeButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCalculatorHandEntryFragment(0)
            rootView.findNavController().navigate(action)
        }

        binding.decisionModeButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToBotHandEntryFragment()
            rootView.findNavController().navigate(action)
        }

        return rootView
    }

}