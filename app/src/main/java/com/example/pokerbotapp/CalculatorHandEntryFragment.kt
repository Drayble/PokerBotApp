package com.example.pokerbotapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.pokerbotapp.databinding.FragmentCalculatorHandEntryBinding


class CalculatorHandEntryFragment : Fragment() {

    private var _binding : FragmentCalculatorHandEntryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalculatorHandEntryBinding.inflate(inflater, container, false)
        val rootView = binding.root


        //binding.returnedvaluetesttextview.text = "THE RETURNED VALUE IS $returnedVal"

        binding.cardSelectorImageButton1.setOnClickListener {
            val action = CalculatorHandEntryFragmentDirections.actionCalculatorHandEntryFragmentToCardSelectionFragment()
            rootView.findNavController().navigate(action)
        }
        binding.cardSelectorImageButton2.setOnClickListener {
            val action = CalculatorHandEntryFragmentDirections.actionCalculatorHandEntryFragmentToCardSelectionFragment()
            rootView.findNavController().navigate(action)
        }

        return rootView
    }
}