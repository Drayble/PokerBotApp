package com.example.pokerbotapp

import androidx.recyclerview.widget.RecyclerView
import com.example.pokerbotapp.databinding.RowOfCardsLayoutBinding

class CardRowItemViewHolder(val binding: RowOfCardsLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentCardRow: CardRow

    fun bindCardRow(cardRow: CardRow) {
        currentCardRow = cardRow
        binding.imgbutton1.setImageResource(currentCardRow.cardImgResourceID1)
        binding.imgbutton2.setImageResource(currentCardRow.cardImgResourceID2)
        binding.imgbutton3.setImageResource(currentCardRow.cardImgResourceID3)
        binding.imgbutton4.setImageResource(currentCardRow.cardImgResourceID4)
    }
}