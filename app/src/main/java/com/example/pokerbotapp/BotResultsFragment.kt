package com.example.pokerbotapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.pokerbotapp.databinding.FragmentBotResultsBinding



class BotResultsFragment : Fragment() {

    private var _binding : FragmentBotResultsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBotResultsBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.card1.setImageResource(viewModel.handCardOneImgRsc)
        binding.card2.setImageResource(viewModel.handCardTwoImgRsc)

        binding.continueButton.setOnClickListener {
            val action = BotResultsFragmentDirections.actionBotResultsFragmentToBotFlopEntryFragment()
            rootView.findNavController().navigate(action)
        }

        return rootView
    }
}