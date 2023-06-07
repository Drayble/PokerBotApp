package com.example.pokerbotapp

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pokerbotapp.databinding.FragmentBotHandEntryBinding
import com.google.android.material.snackbar.Snackbar


class BotHandEntryFragment : Fragment() {

    private var _binding : FragmentBotHandEntryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBotHandEntryBinding.inflate(inflater, container, false)
        val rootView = binding.root

        //updates card images
        binding.cardSelectorImageButton1.setImageResource(viewModel.handCardOneImgRsc)
        binding.cardSelectorImageButton2.setImageResource(viewModel.handCardTwoImgRsc)

        binding.cardSelectorImageButton1.setOnClickListener {
            viewModel.updateSelectTypeToggle(false)
            viewModel.updateHandSelectToggle(1)
            viewModel.unflipCard(viewModel.handCardOneIndex)
            val action = BotHandEntryFragmentDirections.actionBotHandEntryFragmentToCardSelectionFragment()
            rootView.findNavController().navigate(action)
        }
        binding.cardSelectorImageButton2.setOnClickListener {
            viewModel.updateSelectTypeToggle(false)
            viewModel.updateHandSelectToggle(2)
            viewModel.unflipCard(viewModel.handCardTwoIndex)
            val action = BotHandEntryFragmentDirections.actionBotHandEntryFragmentToCardSelectionFragment()
            rootView.findNavController().navigate(action)
        }

        binding.continueButton.setOnClickListener {
            if (!(TextUtils.isEmpty(binding.chipCountEditText.text.toString()))) {
                val numChips = (binding.chipCountEditText.text).toString().toInt()
                if (numChips > 0) {
                    if (!(TextUtils.isEmpty(binding.playerCountEditText.text.toString()))) {
                        val numPlayers = (binding.playerCountEditText.text).toString().toInt()
                        if (numPlayers > 0) {
                            if ((viewModel.handCardOneIndex != 0) && (viewModel.handCardTwoIndex != 0))  {
                                viewModel.setChipCount(numChips)
                                viewModel.setPlayerCount(numPlayers)
                                val action = BotHandEntryFragmentDirections.actionBotHandEntryFragmentToBotResultsFragment()
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
                else {
                    Snackbar.make(rootView, R.string.failed_chip_snackbar, Snackbar.LENGTH_SHORT).show()
                }
            }
            else {
                Snackbar.make(rootView, R.string.no_chip_snackbar, Snackbar.LENGTH_SHORT).show()
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