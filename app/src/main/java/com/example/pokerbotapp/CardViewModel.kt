package com.example.pokerbotapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CardViewModel : ViewModel() {
    //------------------------------
    //GLOBAL VARIABLES AND FUNCTIONS
    //------------------------------
    val cardResourceList = listOf(R.drawable.placeholder, R.drawable.placeholder2, R.drawable.placeholder)

    fun getImgSrc(index: Int) : Int {
        Log.i("GETIMG", "INDEX IS $index")
        return cardResourceList[index]
    }

    //TODO: TRIPLE-CHECK THAT THIS RESETS EVERYTHING WHEN YOU'RE FINISHED
    fun resetTheEntireViewModelForAllOfEternity() {
        _cardOneImgRsc = R.drawable.placeholder
        _cardTwoImgRsc = R.drawable.placeholder
        _handSelectToggle = false
    }


    //----------------------------
    //HAND VARIABLES AND FUNCTIONS
    //----------------------------
    private var _cardOneImgRsc = R.drawable.placeholder
    val cardOneImgRsc: Int
        get() = _cardOneImgRsc

    private var _cardTwoImgRsc = R.drawable.placeholder
    val cardTwoImgRsc: Int
        get() = _cardTwoImgRsc

    private var _handSelectToggle = false
    val handSelectToggle: Boolean
        get() = _handSelectToggle

    /*
    FALSE = Card One        TRUE = Card Two
     */
    fun updateHandSelectToggle(newVal: Boolean) {
        _handSelectToggle = newVal
    }

    fun setNewHandCard(newVal: Int) {
        if (handSelectToggle) {
            _cardTwoImgRsc = cardResourceList[newVal]
        }
        else {
            _cardOneImgRsc = cardResourceList[newVal]
        }
    }
}