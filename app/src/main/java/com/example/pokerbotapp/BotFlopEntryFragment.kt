package com.example.pokerbotapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pokerbotapp.databinding.FragmentBotFlopEntryBinding



class BotFlopEntryFragment : Fragment() {

    private var _binding : FragmentBotFlopEntryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBotFlopEntryBinding.inflate(inflater, container, false)
        val rootView = binding.root

        //sets & updates card images
        binding.imgbutton1.setImageResource(viewModel.flopCardOneImgRsc)
        binding.imgbutton2.setImageResource(viewModel.flopCardTwoImgRsc)
        binding.imgbutton3.setImageResource(viewModel.flopCardThreeImgRsc)
        binding.imgbutton4.setImageResource(viewModel.flopCardFourImgRsc)
        binding.imgbutton5.setImageResource(viewModel.flopCardFiveImgRsc)

        when (viewModel.flopPass) {
            1 -> {
                binding.flopDirectionsTextView.text = getString(R.string.flop_directions1)
            }
            2 -> {
                binding.flopDirectionsTextView.text = getString(R.string.flop_directions2)
            }
            3 -> {
                binding.flopDirectionsTextView.text = getString(R.string.flop_directions3)
            }
            else -> {
                binding.flopDirectionsTextView.text = getString(R.string.flop_directions1)
            }
        }

        //only accessible on first pass
        binding.imgbutton1.setOnClickListener{
            if (viewModel.flopPass == 1) {
                viewModel.updateSelectTypeToggle(true)
                viewModel.updateFlopSelectToggle(1)
                viewModel.unflipCard(viewModel.flopCardOneIndex)
                val action = BotFlopEntryFragmentDirections.actionBotFlopEntryFragmentToCardSelectionFragment()
                rootView.findNavController().navigate(action)
            }
        }
        binding.imgbutton2.setOnClickListener{
            if (viewModel.flopPass == 1) {
                viewModel.updateSelectTypeToggle(true)
                viewModel.updateFlopSelectToggle(2)
                viewModel.unflipCard(viewModel.flopCardTwoIndex)
                val action = BotFlopEntryFragmentDirections.actionBotFlopEntryFragmentToCardSelectionFragment()
                rootView.findNavController().navigate(action)
            }
        }
        binding.imgbutton3.setOnClickListener{
            if (viewModel.flopPass == 1) {
                viewModel.updateSelectTypeToggle(true)
                viewModel.updateFlopSelectToggle(3)
                viewModel.unflipCard(viewModel.flopCardThreeIndex)
                val action = BotFlopEntryFragmentDirections.actionBotFlopEntryFragmentToCardSelectionFragment()
                rootView.findNavController().navigate(action)
            }
        }
        //only accessible on second pass
        binding.imgbutton4.setOnClickListener{
            if (viewModel.flopPass == 2) {
                viewModel.updateSelectTypeToggle(true)
                viewModel.updateFlopSelectToggle(4)
                viewModel.unflipCard(viewModel.flopCardFourIndex)
                val action = BotFlopEntryFragmentDirections.actionBotFlopEntryFragmentToCardSelectionFragment()
                rootView.findNavController().navigate(action)
            }
        }
        //only accessible on third pass
        binding.imgbutton5.setOnClickListener{
            if (viewModel.flopPass == 3) {
                viewModel.updateSelectTypeToggle(true)
                viewModel.updateFlopSelectToggle(5)
                viewModel.unflipCard(viewModel.flopCardFiveIndex)
                val action = BotFlopEntryFragmentDirections.actionBotFlopEntryFragmentToCardSelectionFragment()
                rootView.findNavController().navigate(action)
            }
        }


        binding.continueButton.setOnClickListener{
            when (viewModel.flopPass) {
                1 -> {
                    if ((viewModel.flopCardOneIndex != 0) && (viewModel.flopCardTwoIndex != 0) && (viewModel.flopCardThreeIndex != 0)) {
                        viewModel.updateFlopPass()
                        rootView.findNavController().navigateUp()
                    }
                    else {
                        Toast.makeText(activity, "Please input all 3 cards before moving on.", Toast.LENGTH_SHORT).show()
                    }
                }
                2 -> {
                    if (viewModel.flopCardFourIndex != 0) {
                        viewModel.updateFlopPass()
                        rootView.findNavController().navigateUp()
                    }
                    else {
                        Toast.makeText(activity, "Please input the 4th card before moving on.", Toast.LENGTH_SHORT).show()
                    }
                }
                3 -> {
                    if (viewModel.flopCardFiveIndex != 0) {
                        viewModel.updateFlopPass()
                        rootView.findNavController().navigateUp()
                    }
                    else {
                        Toast.makeText(activity, "Please input the last card before moving on.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        setHasOptionsMenu(true)

        return rootView
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}