package com.example.pokerbotapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pokerbotapp.databinding.FragmentBotResultsBinding
import kotlin.math.ceil


class BotResultsFragment : Fragment() {

    private var _binding : FragmentBotResultsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBotResultsBinding.inflate(inflater, container, false)
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


        val mystery = (1..100).random()

        //just the starting hand
        if (viewModel.flopPass == 1) {
            binding.card1.setImageResource(playerHand[0].cardImgRsc)
            binding.card2.setImageResource(playerHand[1].cardImgRsc)
            binding.resultsDescriptionTextView.text = if (mystery == 52) {
                "Go all in with your ${viewModel.chipCount} chips"
            }
            else if (LogicSystem.HandMethods.StartingHandMethods().getStartingHandChenVal(playerHand[0], playerHand[1]) > 2) {
                "Bet either ${ceil(viewModel.chipCount * 0.1)} or ${ceil(viewModel.chipCount * 0.2)} chips"
            }
            else {
                "Check if possible, fold if someone bets anything"
            }

        }
        // starting hand  + first 3 flop
        else if (viewModel.flopPass == 2) {
            val inputList = listOf(playerHand[0], playerHand[1], playerHand[2], playerHand[3], playerHand[4])
            val printList: ArrayList<Card> = LogicSystem.GlobalMethods().getBestHand(inputList)
            binding.card1.setImageResource(printList[0].cardImgRsc)
            binding.card2.setImageResource(printList[1].cardImgRsc)
            binding.card3.setImageResource(printList[2].cardImgRsc)
            binding.card4.setImageResource(printList[3].cardImgRsc)
            binding.card5.setImageResource(printList[4].cardImgRsc)
            binding.resultsDescriptionTextView.text = if (mystery == 52) {
                "Go all in with your ${viewModel.chipCount} chips"
            }
            else if (LogicSystem.GlobalMethods().getBetLevelBasic(inputList) == 2) {
                "Bet either ${ceil(viewModel.chipCount * 0.3)} or ${ceil(viewModel.chipCount * 0.4)} chips"
            }
            else {
                "Check if possible, fold if someone bets anything"
            }
        }
        //first sort function (6 cards)
        else if (viewModel.flopPass == 3) {
            val inputList = listOf(playerHand[0], playerHand[1], playerHand[2], playerHand[3], playerHand[4], playerHand[5])
            val printList: ArrayList<Card> = LogicSystem.GlobalMethods().getBestHand(inputList)
            binding.card1.setImageResource(printList[0].cardImgRsc)
            binding.card2.setImageResource(printList[1].cardImgRsc)
            binding.card3.setImageResource(printList[2].cardImgRsc)
            binding.card4.setImageResource(printList[3].cardImgRsc)
            binding.card5.setImageResource(printList[4].cardImgRsc)
            binding.resultsDescriptionTextView.text = if (mystery == 52) {
                "Go all in with your ${viewModel.chipCount} chips"
            }
            else if (LogicSystem.GlobalMethods().getBetLevelBasic(inputList) == 2) {
                "Bet either ${ceil(viewModel.chipCount * 0.5)} or ${ceil(viewModel.chipCount * 0.6)} chips"
            }
            else {
                "Check if possible, fold if someone bets anything"
            }
        }
        //2nd sort function (7 cards)
        else {
            val inputList = listOf(playerHand[0], playerHand[1], playerHand[2], playerHand[3], playerHand[4], playerHand[5], playerHand[6])
            val printList: ArrayList<Card> = LogicSystem.GlobalMethods().getBestHand(inputList)
            binding.card1.setImageResource(printList[0].cardImgRsc)
            binding.card2.setImageResource(printList[1].cardImgRsc)
            binding.card3.setImageResource(printList[2].cardImgRsc)
            binding.card4.setImageResource(printList[3].cardImgRsc)
            binding.card5.setImageResource(printList[4].cardImgRsc)
            binding.resultsDescriptionTextView.text = if (mystery == 52) {
                "Go all in with your ${viewModel.chipCount} chips"
            }
            else if (LogicSystem.GlobalMethods().getBetLevelBasic(inputList) == 2) {
                "Bet either ${ceil(viewModel.chipCount * 0.7)} or ${ceil(viewModel.chipCount * 0.8)} chips"
            }
            else {
                "Check if possible, fold if someone bets anything"
            }
        }

        binding.continueButton.setOnClickListener {
            if (viewModel.flopPass <= 3) {
                val action = BotResultsFragmentDirections.actionBotResultsFragmentToBotFlopEntryFragment()
                rootView.findNavController().navigate(action)
            }
            else {
                rootView.findNavController().navigateUp()
                rootView.findNavController().navigateUp()
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