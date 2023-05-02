 package com.example.pokerbotapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.pokerbotapp.databinding.FragmentCardSelectionBinding

class CardSelectionFragment : Fragment() {

    private var _binding : FragmentCardSelectionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCardSelectionBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val i: Int = R.drawable.placeholder

        val cardButtonRows = listOf(
            /*Twos*/CardRow(CardButton(i, 1), CardButton(i, 2), CardButton(i, 3), CardButton(i, 4)),
            /*Threes*/CardRow(CardButton(i, 5), CardButton(i, 6), CardButton(i, 7), CardButton(i, 8)),
            /*Fours*/CardRow(CardButton(i, 9), CardButton(i, 10), CardButton(i, 11), CardButton(i, 12)),
            /*Fives*/CardRow(CardButton(i, 13), CardButton(i, 14), CardButton(i, 15), CardButton(i, 16)),
            /*Sixes*/CardRow(CardButton(i, 17), CardButton(i, 18), CardButton(i, 19), CardButton(i, 20)),
            /*Sevens*/CardRow(CardButton(i, 21), CardButton(i, 22), CardButton(i, 23), CardButton(i, 24)),
            /*Eights*/CardRow(CardButton(i, 25), CardButton(i, 26), CardButton(i, 27), CardButton(i, 28)),
            /*Nines*/CardRow(CardButton(i, 29), CardButton(i, 30), CardButton(i, 31), CardButton(i, 32)),
            /*Tens*/CardRow(CardButton(i, 33), CardButton(i, 34), CardButton(i, 35), CardButton(i, 36)),
            /*Jacks*/CardRow(CardButton(i, 37), CardButton(i, 38), CardButton(i, 39), CardButton(i, 40)),
            /*Queens*/CardRow(CardButton(i, 41), CardButton(i, 42), CardButton(i, 43), CardButton(i, 44)),
            /*Kings*/CardRow(CardButton(i, 45), CardButton(i, 46), CardButton(i, 47), CardButton(i, 48)),
            /*Aces*/CardRow(CardButton(i, 49), CardButton(i, 50), CardButton(i, 51), CardButton(i, 52)))

        val mAdapter = CardRowItemAdapter(cardButtonRows, viewModel)
        binding.cardSelectionRecyclerView.adapter = mAdapter


        return rootView
    }
}