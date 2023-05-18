package com.example.pokerbotapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.pokerbotapp.databinding.FragmentCalculatorHandEntryBinding


class CalculatorHandEntryFragment : Fragment() {

    private var _binding : FragmentCalculatorHandEntryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()
    private var signpost = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalculatorHandEntryBinding.inflate(inflater, container, false)
        val rootView = binding.root

        //sets & updates card images
        binding.cardSelectorImageButton1.setImageResource(viewModel.handCardOneImgRsc)
        binding.cardSelectorImageButton2.setImageResource(viewModel.handCardTwoImgRsc)


        /*
        TODO: Go through all imageviews & buttons and resize them to the correct/new dimensions
         */

        binding.cardSelectorImageButton1.setOnClickListener {
            viewModel.updateSelectTypeToggle(false)
            viewModel.updateHandSelectToggle(1)
            viewModel.unflipCard(viewModel.handCardOneIndex)
            val action = CalculatorHandEntryFragmentDirections.actionCalculatorHandEntryFragmentToCardSelectionFragment()
            rootView.findNavController().navigate(action)
        }
        binding.cardSelectorImageButton2.setOnClickListener {
            viewModel.updateSelectTypeToggle(false)
            viewModel.updateHandSelectToggle(2)
            viewModel.unflipCard(viewModel.handCardTwoIndex)
            val action = CalculatorHandEntryFragmentDirections.actionCalculatorHandEntryFragmentToCardSelectionFragment()
            rootView.findNavController().navigate(action)
        }


        binding.continueButton.setOnClickListener {
            val action = CalculatorHandEntryFragmentDirections.actionCalculatorHandEntryFragmentToCalculatorResultsFragment()
            rootView.findNavController().navigate(action)
        }

        return rootView
    }
}
