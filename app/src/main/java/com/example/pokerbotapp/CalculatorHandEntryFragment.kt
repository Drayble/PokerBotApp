package com.example.pokerbotapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.pokerbotapp.databinding.FragmentCalculatorHandEntryBinding
import kotlin.math.sign


class CalculatorHandEntryFragment : Fragment() {

    private var _binding : FragmentCalculatorHandEntryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()
    private var signpost = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalculatorHandEntryBinding.inflate(inflater, container, false)
        val rootView = binding.root

        //updates card images
        viewModel.handCardOneVal.observe(viewLifecycleOwner) { newVal ->
            if (signpost == 0) {
                Log.i("UPDATED CARD IMAGE", "Card one")
                binding.cardSelectorImageButton1.setImageResource(viewModel.getImgSrc(newVal))
            }
        }
        viewModel.handCardOneVal.observe(viewLifecycleOwner) { newVal ->
            if (signpost == 1) {
                Log.i("UPDATED CARD IMAGE", "Card two")
                binding.cardSelectorImageButton2.setImageResource(viewModel.getImgSrc(newVal))
            }
        }

        binding.cardSelectorImageButton1.setOnClickListener {
            signpost = 0
            val action = CalculatorHandEntryFragmentDirections.actionCalculatorHandEntryFragmentToCardSelectionFragment()
            rootView.findNavController().navigate(action)
        }
        binding.cardSelectorImageButton2.setOnClickListener {
            signpost = 1
            val action = CalculatorHandEntryFragmentDirections.actionCalculatorHandEntryFragmentToCardSelectionFragment()
            rootView.findNavController().navigate(action)
        }

        return rootView
    }
}