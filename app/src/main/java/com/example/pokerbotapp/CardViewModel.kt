package com.example.pokerbotapp

import android.util.Log
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
        _handCardOneImgRsc = R.drawable.placeholder
        _handCardTwoImgRsc = R.drawable.placeholder
        _handCardOneIndex = 0
        _handCardTwoIndex = 0
        _handSelectToggle = false
        for (i in cardIsTakenList.indices) {
            cardIsTakenList[i] = false
        }
        _flopCardOneImgRsc = R.drawable.placeholder
        _flopCardTwoImgRsc = R.drawable.placeholder
        _flopCardThreeImgRsc = R.drawable.placeholder
        _flopCardFourImgRsc = R.drawable.placeholder
        _flopCardFiveImgRsc = R.drawable.placeholder
        _flopPass = 1
    }


    //----------------------------
    //HAND VARIABLES AND FUNCTIONS
    //----------------------------
    private var _handCardOneImgRsc = R.drawable.placeholder
    val handCardOneImgRsc: Int
        get() = _handCardOneImgRsc

    private var _handCardOneIndex = 0
    val handCardOneIndex: Int
        get() = _handCardOneIndex

    private var _handCardTwoImgRsc = R.drawable.placeholder
    val handCardTwoImgRsc: Int
        get() = _handCardTwoImgRsc

    private var _handCardTwoIndex = 0
    val handCardTwoIndex: Int
        get() = _handCardTwoIndex

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
            _handCardTwoImgRsc = cardResourceList[newVal]
            _handCardTwoIndex = newVal
        }
        else {
            _handCardOneImgRsc = cardResourceList[newVal]
            _handCardOneIndex = newVal
        }
    }



    //----------------------------
    //FLOP VARIABLES AND FUNCTIONS
    //----------------------------
    private var _flopCardOneImgRsc = R.drawable.placeholder
    val flopCardOneImgRsc: Int
        get() = _flopCardOneImgRsc

    private var _flopCardTwoImgRsc = R.drawable.placeholder
    val flopCardTwoImgRsc: Int
        get() = _flopCardTwoImgRsc

    private var _flopCardThreeImgRsc = R.drawable.placeholder
    val flopCardThreeImgRsc: Int
        get() = _flopCardThreeImgRsc

    private var _flopCardFourImgRsc = R.drawable.placeholder
    val flopCardFourImgRsc: Int
        get() = _flopCardFourImgRsc

    private var _flopCardFiveImgRsc = R.drawable.placeholder
    val flopCardFiveImgRsc: Int
        get() = _flopCardFiveImgRsc

    private var _flopPass = 1
    val flopPass: Int
        get() = _flopPass

    fun updateFlopPass() {
        _flopPass++
    }
}