package com.example.pokerbotapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.pokerbotapp.databinding.FragmentBotHandEntryBinding



class BotHandEntryFragment : Fragment() {

    private var _binding : FragmentBotHandEntryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBotHandEntryBinding.inflate(inflater, container, false)
        val rootView = binding.root

        //updates card images
        binding.cardSelectorImageButton1.setImageResource(viewModel.cardOneImgRsc)
        binding.cardSelectorImageButton2.setImageResource(viewModel.cardTwoImgRsc)


        binding.cardSelectorImageButton1.setOnClickListener {
            viewModel.updateHandSelectToggle(false)
            val action = BotHandEntryFragmentDirections.actionBotHandEntryFragmentToCardSelectionFragment()
            rootView.findNavController().navigate(action)
        }
        binding.cardSelectorImageButton2.setOnClickListener {
            viewModel.updateHandSelectToggle(true)
            val action = BotHandEntryFragmentDirections.actionBotHandEntryFragmentToCardSelectionFragment()
            rootView.findNavController().navigate(action)
        }

        binding.continueButton.setOnClickListener {
            val action = BotHandEntryFragmentDirections.actionBotHandEntryFragmentToBotResultsFragment()
            rootView.findNavController().navigate(action)
        }

        return rootView
    }
}