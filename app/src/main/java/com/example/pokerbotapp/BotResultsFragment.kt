package com.example.pokerbotapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokerbotapp.databinding.FragmentBotResultsBinding



class BotResultsFragment : Fragment() {

    private var _binding : FragmentBotResultsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBotResultsBinding.inflate(inflater, container, false)
        val rootView = binding.root

        return rootView
    }
}