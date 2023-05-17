package com.example.pokerbotapp

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokerbotapp.databinding.RowOfCardsLayoutBinding

class CardRowItemViewHolder(val binding: RowOfCardsLayoutBinding, val viewModel: CardViewModel): RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentCardRow: CardRow

    init {
        binding.imgbutton1.setOnClickListener {
            val value = currentCardRow.cardButton1.indexedValue
            if (!(viewModel.cardIsTakenList[value])) {
                if (viewModel.selectTypeToggle) {
                    viewModel.setNewFlopCard(value)
                }
                else {
                    viewModel.setNewHandCard(value)
                }
                viewModel.flipOverCard(value)
                binding.root.findNavController().navigateUp()
            }
        }
        binding.imgbutton2.setOnClickListener {
            val value = currentCardRow.cardButton2.indexedValue
            if (!(viewModel.cardIsTakenList[value])) {
                if (viewModel.selectTypeToggle) {
                    viewModel.setNewFlopCard(value)
                }
                else {
                    viewModel.setNewHandCard(value)
                }
                viewModel.flipOverCard(value)
                binding.root.findNavController().navigateUp()
            }
        }
        binding.imgbutton3.setOnClickListener {
            val value = currentCardRow.cardButton3.indexedValue
            if (!(viewModel.cardIsTakenList[value])) {
                if (viewModel.selectTypeToggle) {
                    viewModel.setNewFlopCard(value)
                }
                else {
                    viewModel.setNewHandCard(value)
                }
                viewModel.flipOverCard(value)
                binding.root.findNavController().navigateUp()
            }
        }
        binding.imgbutton4.setOnClickListener {
            val value = currentCardRow.cardButton4.indexedValue
            if (!(viewModel.cardIsTakenList[value])) {
                if (viewModel.selectTypeToggle) {
                    viewModel.setNewFlopCard(value)
                }
                else {
                    viewModel.setNewHandCard(value)
                }
                viewModel.flipOverCard(value)
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