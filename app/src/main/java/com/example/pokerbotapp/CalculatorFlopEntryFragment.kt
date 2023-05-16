package com.example.pokerbotapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.pokerbotapp.databinding.FragmentCalculatorFlopEntryBinding



class CalculatorFlopEntryFragment : Fragment() {

    private var _binding : FragmentCalculatorFlopEntryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalculatorFlopEntryBinding.inflate(inflater, container, false)
        val rootView = binding.root

        //sets & updates card images
        binding.imgbutton1.setImageResource(viewModel.flopCardOneImgRsc)
        binding.imgbutton2.setImageResource(viewModel.flopCardTwoImgRsc)
        binding.imgbutton3.setImageResource(viewModel.flopCardThreeImgRsc)
        binding.imgbutton4.setImageResource(viewModel.flopCardFourImgRsc)
        binding.imgbutton5.setImageResource(viewModel.flopCardFiveImgRsc)

        //only accessible on first pass
        binding.imgbutton1.setOnClickListener{
            if (viewModel.flopPass == 1) {
                viewModel.updateFlopSelectToggle(1)
                viewModel.unflipCard(viewModel.flopCardOneIndex)
                val action = CalculatorFlopEntryFragmentDirections.actionCalculatorFlopEntryFragmentToCardSelectionFragment()
                rootView.findNavController().navigate(action)
            }
        }
        binding.imgbutton2.setOnClickListener{
            if (viewModel.flopPass == 1) {
                viewModel.updateFlopSelectToggle(2)
                viewModel.unflipCard(viewModel.flopCardTwoIndex)
                val action = CalculatorFlopEntryFragmentDirections.actionCalculatorFlopEntryFragmentToCardSelectionFragment()
                rootView.findNavController().navigate(action)
            }
        }
        binding.imgbutton3.setOnClickListener{
            if (viewModel.flopPass == 1) {
                viewModel.updateFlopSelectToggle(3)
                viewModel.unflipCard(viewModel.flopCardThreeIndex)
                val action = CalculatorFlopEntryFragmentDirections.actionCalculatorFlopEntryFragmentToCardSelectionFragment()
                rootView.findNavController().navigate(action)
            }
        }
        //only accessible on second pass
        binding.imgbutton4.setOnClickListener{
            if (viewModel.flopPass == 2) {
                viewModel.updateFlopSelectToggle(4)
                viewModel.unflipCard(viewModel.flopCardFourIndex)
                val action = CalculatorFlopEntryFragmentDirections.actionCalculatorFlopEntryFragmentToCardSelectionFragment()
                rootView.findNavController().navigate(action)
            }
        }
        //only accessible on third pass
        binding.imgbutton5.setOnClickListener{
            if (viewModel.flopPass == 3) {
                viewModel.updateFlopSelectToggle(5)
                viewModel.unflipCard(viewModel.flopCardFiveIndex)
                val action = CalculatorFlopEntryFragmentDirections.actionCalculatorFlopEntryFragmentToCardSelectionFragment()
                rootView.findNavController().navigate(action)
            }
        }


        binding.continueButton.setOnClickListener{
            viewModel.updateFlopPass()
        }


        return rootView
    }
}