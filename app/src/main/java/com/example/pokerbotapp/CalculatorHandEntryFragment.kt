package com.example.pokerbotapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pokerbotapp.databinding.FragmentCalculatorHandEntryBinding
import com.google.android.material.snackbar.Snackbar


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
            if (!(TextUtils.isEmpty(binding.playerCountEditText.text.toString()))) {
                val numPlayers = (binding.playerCountEditText.text).toString().toInt()
                if (numPlayers > 0) {
                    if ((viewModel.handCardOneIndex != 0) && (viewModel.handCardTwoIndex != 0))  {
                        viewModel.setPlayerCount(numPlayers)
                        val action = CalculatorHandEntryFragmentDirections.actionCalculatorHandEntryFragmentToCalculatorResultsFragment()
                        rootView.findNavController().navigate(action)
                    }
                    else {
                        Toast.makeText(activity, "Please input both cards before moving on.", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Snackbar.make(rootView, R.string.failed_player_snackbar, Snackbar.LENGTH_SHORT).show()
                }
            }
            else {
                Snackbar.make(rootView, R.string.no_player_snackbar, Snackbar.LENGTH_SHORT).show()
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
