package com.example.pokerbotapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.pokerbotapp.databinding.FragmentCalculatorResultsBinding



class CalculatorResultsFragment : Fragment() {

    private var _binding : FragmentCalculatorResultsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalculatorResultsBinding.inflate(inflater, container, false)
        val rootView = binding.root


        if (viewModel.flopPass <= 3) {
            binding.continueButton.text = resources.getString(R.string.continue_)
        }
        else {
            binding.continueButton.text = resources.getString(R.string.restart_)
        }


        val playerHand = listOf(
            // "HAND" CARDS
            Card(viewModel.handCardOneIndex, viewModel.handCardOneImgRsc),
            Card(viewModel.handCardTwoIndex, viewModel.handCardTwoImgRsc),
            // "TABLE" CARDS
            Card(viewModel.flopCardOneIndex, viewModel.flopCardOneImgRsc),
            Card(viewModel.flopCardTwoIndex, viewModel.flopCardTwoImgRsc),
            Card(viewModel.flopCardThreeIndex, viewModel.flopCardThreeImgRsc),
            Card(viewModel.flopCardFourIndex, viewModel.flopCardFourImgRsc),
            Card(viewModel.flopCardFiveIndex, viewModel.flopCardFiveImgRsc))

        //just the starting hand
        if (viewModel.flopPass == 1) {
            binding.card1.setImageResource(viewModel.handCardOneImgRsc)
            binding.card2.setImageResource(viewModel.handCardTwoImgRsc)
            Log.i("CALCRESULTS", "${playerHand[0].chenVal}")
            Log.i("CALCRESULTS", "${playerHand[1].chenVal}")
            binding.resultsDescriptionTextView.text = "Your starting hand is a " + LogicSystem.HandMethods.StartingHandMethods().
            getStartingHandChenVal(playerHand[0], playerHand[1]) + " based on the Chen Formula. (The average score is a 4.4852. Use that information however you like)"
        }
        // starting hand  + first 3 flop
        else if (viewModel.flopPass == 2) {
            binding.card1.setImageResource(viewModel.handCardOneImgRsc)
            binding.card2.setImageResource(viewModel.handCardTwoImgRsc)
            binding.card3.setImageResource(viewModel.flopCardOneImgRsc)
            binding.card4.setImageResource(viewModel.flopCardTwoImgRsc)
            binding.card5.setImageResource(viewModel.flopCardThreeImgRsc)
        }
        //first sort function (6 cards)
        else if (viewModel.flopPass == 3) {

        }
        //2nd sort function (7 cards)
        else {

        }


        binding.continueButton.setOnClickListener {
            if (viewModel.flopPass <= 3) {
                val action = CalculatorResultsFragmentDirections.actionCalculatorResultsFragmentToCalculatorFlopEntryFragment()
                rootView.findNavController().navigate(action)
            }
            else {
                rootView.findNavController().navigateUp()
                rootView.findNavController().navigateUp()
            }
        }

        return rootView
    }


}