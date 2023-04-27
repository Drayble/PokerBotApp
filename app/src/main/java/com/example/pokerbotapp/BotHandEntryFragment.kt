package com.example.pokerbotapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.pokerbotapp.databinding.FragmentBotHandEntryBinding



class BotHandEntryFragment : Fragment() {

    private var _binding : FragmentBotHandEntryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBotHandEntryBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.cardSelectorImageButton1.setOnClickListener {
            val action = BotHandEntryFragmentDirections.actionBotHandEntryFragmentToCardSelectionFragment()
            rootView.findNavController().navigate(action)
        }
        binding.cardSelectorImageButton2.setOnClickListener {
            val action = BotHandEntryFragmentDirections.actionBotHandEntryFragmentToCardSelectionFragment()
            rootView.findNavController().navigate(action)
        }

        return rootView
    }
}