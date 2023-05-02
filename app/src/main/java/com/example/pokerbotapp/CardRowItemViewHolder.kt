package com.example.pokerbotapp

import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokerbotapp.databinding.RowOfCardsLayoutBinding

class CardRowItemViewHolder(val binding: RowOfCardsLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentCardRow: CardRow



    init {
        binding.imgbutton1.setOnClickListener {
            val returnVal = currentCardRow.cardButton1.indexedValue
            val action = CardSelectionFragmentDirections.actionCardSelectionFragmentToCalculatorHandEntryFragment(returnVal)
            binding.root.findNavController().navigate(action)
        }
        binding.imgbutton2.setOnClickListener {
            val returnVal = currentCardRow.cardButton2.indexedValue
            val action = CardSelectionFragmentDirections.actionCardSelectionFragmentToCalculatorHandEntryFragment(returnVal)
            binding.root.findNavController().navigate(action)
        }
        binding.imgbutton3.setOnClickListener {
            val returnVal = currentCardRow.cardButton3.indexedValue
            val action = CardSelectionFragmentDirections.actionCardSelectionFragmentToCalculatorHandEntryFragment(returnVal)
            binding.root.findNavController().navigate(action)
        }
        binding.imgbutton4.setOnClickListener {
            val returnVal = currentCardRow.cardButton4.indexedValue
            val action = CardSelectionFragmentDirections.actionCardSelectionFragmentToCalculatorHandEntryFragment(returnVal)
            binding.root.findNavController().navigate(action)
        }
    }

    fun bindCardRow(cardRow: CardRow) {
        currentCardRow = cardRow
        binding.imgbutton1.setImageResource(currentCardRow.cardButton1.cdImgRsc)
        binding.imgbutton2.setImageResource(currentCardRow.cardButton2.cdImgRsc)
        binding.imgbutton3.setImageResource(currentCardRow.cardButton3.cdImgRsc)
        binding.imgbutton4.setImageResource(currentCardRow.cardButton4.cdImgRsc)
    }
}