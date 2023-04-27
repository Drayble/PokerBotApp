package com.example.pokerbotapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokerbotapp.databinding.RowOfCardsLayoutBinding

class CardRowItemAdapter(val cardRowList: List<CardRow>): RecyclerView.Adapter<CardRowItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardRowItemViewHolder {
        val binding = RowOfCardsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardRowItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardRowItemViewHolder, position: Int) {
        val currentCardRow = cardRowList[position]
        holder.bindCardRow(currentCardRow)
    }

    override fun getItemCount(): Int {
        return cardRowList.size
    }

}