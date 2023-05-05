package com.example.pokerbotapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CardViewModel : ViewModel() {
    //------------------------------
    //GLOBAL VARIABLES AND FUNCTIONS
    //------------------------------
    val cardResourceList = listOf(/*Back of the Card*/R.drawable.placeholder2,
        /*Aces*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
        /*Twos*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
        /*Threes*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
        /*Fours*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
        /*Fives*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
        /*Sixes*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
        /*Sevens*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
        /*Eights*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
        /*Nines*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
        /*Tens*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
        /*Jacks*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
        /*Queens*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
        /*Kings*/R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder)

    val cardIsTakenList = mutableListOf(false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false)

    fun getImgSrc(index: Int) : Int {
        Log.i("GETIMG", "INDEX IS $index")
        return cardResourceList[index]
    }

    fun unflipCard(index: Int) {
        cardIsTakenList[index] = false
    }

    //TODO: TRIPLE-CHECK THAT THIS RESETS EVERYTHING WHEN YOU'RE FINISHED
    fun resetTheEntireViewModelForAllOfEternity() {
        _cardOneImgRsc = R.drawable.placeholder
        _cardTwoImgRsc = R.drawable.placeholder
        _cardOneIndex = 0
        _cardTwoIndex = 0
        _handSelectToggle = false
        for (i in cardIsTakenList.indices) {
            cardIsTakenList[i] = false
        }
    }


    //----------------------------
    //HAND VARIABLES AND FUNCTIONS
    //----------------------------
    private var _cardOneImgRsc = R.drawable.placeholder
    val cardOneImgRsc: Int
        get() = _cardOneImgRsc

    private var _cardOneIndex = 0
    val cardOneIndex: Int
        get() = _cardOneIndex

    private var _cardTwoImgRsc = R.drawable.placeholder
    val cardTwoImgRsc: Int
        get() = _cardTwoImgRsc

    private var _cardTwoIndex = 0
    val cardTwoIndex: Int
        get() = _cardTwoIndex

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
            _cardTwoIndex = newVal
        }
        else {
            _cardOneImgRsc = cardResourceList[newVal]
            _cardOneIndex = newVal
        }
    }
}