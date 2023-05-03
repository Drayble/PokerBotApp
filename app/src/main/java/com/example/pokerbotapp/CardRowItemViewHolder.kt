package com.example.pokerbotapp

import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokerbotapp.databinding.RowOfCardsLayoutBinding

class CardRowItemViewHolder(val binding: RowOfCardsLayoutBinding, val viewModel: CardViewModel): RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentCardRow: CardRow


    // I passed in the Viewmodel, now just use it to pass the value into the viewmodel and pull it after you pop
    init {
        binding.imgbutton1.setOnClickListener {
            viewModel.setNewHandCard(currentCardRow.cardButton1.indexedValue)
            binding.root.findNavController().navigateUp()
        }
        binding.imgbutton2.setOnClickListener {
            viewModel.setNewHandCard(currentCardRow.cardButton2.indexedValue)
            binding.root.findNavController().navigateUp()
        }
        binding.imgbutton3.setOnClickListener {
            viewModel.setNewHandCard(currentCardRow.cardButton3.indexedValue)
            binding.root.findNavController().navigateUp()
        }
        binding.imgbutton4.setOnClickListener {
            viewModel.setNewHandCard(currentCardRow.cardButton4.indexedValue)
            binding.root.findNavController().navigateUp()
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