 package com.example.pokerbotapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokerbotapp.databinding.FragmentCardSelectionBinding

class CardSelectionFragment : Fragment() {

    private var _binding : FragmentCardSelectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCardSelectionBinding.inflate(inflater, container, false)
        val rootView = binding.root

        /*Twos*/val cardRows = listOf(CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
            /*Threes*/CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
            /*Fours*/CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
            /*Fives*/CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
            /*Sixes*/CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
            /*Sevens*/CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
            /*Eights*/CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
            /*Nines*/CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
            /*Tens*/CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
            /*Jacks*/CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
            /*Queens*/CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
            /*Kings*/CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
            /*Aces*/CardRow(R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder),
        )

        val mAdapter = CardRowItemAdapter(cardRows)
        binding.cardSelectionRecyclerView.adapter = mAdapter

        return rootView
    }
}