package com.example.pokerbotapp

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokerbotapp.databinding.RowOfCardsLayoutBinding

class CardRowItemViewHolder(val binding: RowOfCardsLayoutBinding, val viewModel: CardViewModel): RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentCardRow: CardRow

    init {
        binding.imgbutton1.setOnClickListener {
            if (!(viewModel.cardIsTakenList[currentCardRow.cardButton1.indexedValue])) {
                viewModel.setNewHandCard(currentCardRow.cardButton1.indexedValue)
                viewModel.cardIsTakenList[currentCardRow.cardButton1.indexedValue] = true
                binding.root.findNavController().navigateUp()
            }
        }
        binding.imgbutton2.setOnClickListener {
            if (!(viewModel.cardIsTakenList[currentCardRow.cardButton2.indexedValue])) {
                viewModel.setNewHandCard(currentCardRow.cardButton2.indexedValue)
                viewModel.cardIsTakenList[currentCardRow.cardButton2.indexedValue] = true
                binding.root.findNavController().navigateUp()
            }
        }
        binding.imgbutton3.setOnClickListener {
            if (!(viewModel.cardIsTakenList[currentCardRow.cardButton3.indexedValue])) {
                viewModel.setNewHandCard(currentCardRow.cardButton3.indexedValue)
                viewModel.cardIsTakenList[currentCardRow.cardButton3.indexedValue] = true
                binding.root.findNavController().navigateUp()
            }
        }
        binding.imgbutton4.setOnClickListener {
            if (!(viewModel.cardIsTakenList[currentCardRow.cardButton4.indexedValue])) {
                viewModel.setNewHandCard(currentCardRow.cardButton4.indexedValue)
                viewModel.cardIsTakenList[currentCardRow.cardButton4.indexedValue] = true
                binding.root.findNavController().navigateUp()
            }
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