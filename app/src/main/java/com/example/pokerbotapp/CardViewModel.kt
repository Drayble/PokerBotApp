package com.example.pokerbotapp

import android.util.Log
import androidx.lifecycle.ViewModel

class CardViewModel : ViewModel() {
    //------------------------------
    //GLOBAL VARIABLES AND FUNCTIONS
    //------------------------------
    val cardResourceList = listOf(/*Back of the Card*/R.drawable.flipped_card,
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

    fun flipOverCard(index: Int) {
        cardIsTakenList[index] = true
    }

    //TODO: TRIPLE-CHECK THAT THIS RESETS EVERYTHING WHEN YOU'RE FINISHED
    fun resetTheEntireViewModelForAllOfEternity() {
        _handCardOneImgRsc = R.drawable.placeholder
        _handCardTwoImgRsc = R.drawable.placeholder
        _handCardOneIndex = 0
        _handCardTwoIndex = 0
        _handSelectToggle = 1
        for (i in cardIsTakenList.indices) {
            cardIsTakenList[i] = false
        }
        _flopCardOneImgRsc = R.drawable.placeholder
        _flopCardTwoImgRsc = R.drawable.placeholder
        _flopCardThreeImgRsc = R.drawable.placeholder
        _flopCardFourImgRsc = R.drawable.placeholder
        _flopCardFiveImgRsc = R.drawable.placeholder
        _flopCardOneIndex = 0
        _flopCardTwoIndex = 0
        _flopCardThreeIndex = 0
        _flopCardFourIndex = 0
        _flopCardFiveIndex = 0
        _flopSelectToggle = 1
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

    private var _handSelectToggle = 1
    val handSelectToggle: Int
        get() = _handSelectToggle

    /*
    FALSE = Card One        TRUE = Card Two
     */
    fun updateHandSelectToggle(newVal: Int) {
        _handSelectToggle = newVal
    }

    fun setNewHandCard(newVal: Int) {
        when (handSelectToggle) {
            1 -> {
                _handCardOneImgRsc = cardResourceList[newVal]
                _handCardOneIndex = newVal
            }
            2 -> {
                _handCardOneImgRsc = cardResourceList[newVal]
                _handCardOneIndex = newVal
            }
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

    private var _flopCardOneIndex = 0
    val flopCardOneIndex: Int
        get() = _flopCardOneIndex

    private var _flopCardTwoIndex = 0
    val flopCardTwoIndex: Int
        get() = _flopCardTwoIndex

    private var _flopCardThreeIndex = 0
    val flopCardThreeIndex: Int
        get() = _flopCardThreeIndex

    private var _flopCardFourIndex = 0
    val flopCardFourIndex: Int
        get() = _flopCardFourIndex

    private var _flopCardFiveIndex = 0
    val flopCardFiveIndex: Int
        get() = _flopCardFiveIndex

    private var _flopPass = 1
    val flopPass: Int
        get() = _flopPass

    private var _flopSelectToggle = 1
    val flopSelectToggle: Int
        get() = _flopSelectToggle


    fun updateFlopPass() {
        _flopPass++
    }

    // CardNum is # 1 through 5
    fun updateFlopSelectToggle(cardNum: Int) {
        _flopSelectToggle = cardNum
    }

    fun setNewFlopCard(newVal: Int) {
        when (flopSelectToggle) {
            1 -> {
                _flopCardOneImgRsc = cardResourceList[newVal]
                _flopCardOneIndex = newVal
            }
            2 -> {
                _flopCardTwoImgRsc = cardResourceList[newVal]
                _flopCardTwoIndex = newVal
            }
            3 -> {
                _flopCardThreeImgRsc = cardResourceList[newVal]
                _flopCardThreeIndex = newVal
            }
            4 -> {
                _flopCardFourImgRsc = cardResourceList[newVal]
                _flopCardFourIndex = newVal
            }
            5 -> {
                _flopCardFiveImgRsc = cardResourceList[newVal]
                _flopCardFiveIndex = newVal
            }
        }
    }
}