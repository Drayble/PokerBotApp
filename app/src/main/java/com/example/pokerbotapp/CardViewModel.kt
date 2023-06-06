package com.example.pokerbotapp

import android.util.Log
import androidx.lifecycle.ViewModel

class CardViewModel : ViewModel() {
    //------------------------------
    //GLOBAL VARIABLES AND FUNCTIONS
    //------------------------------
    val cardResourceList = listOf(/*Back of the Card*/R.drawable.flipped_card,
           /*       ACES                    TWOS                   THREES                   FOURS                  FIVES                   SIXES                   SEVENS                  EIGHTS                  NINES                    TENS                    JACKS                 QUEENS                   KINGS        */
/* Spades */ R.drawable.ace_spades, R.drawable.two_spades, R.drawable.three_spades, R.drawable.four_spades, R.drawable.five_spades, R.drawable.six_spades, R.drawable.seven_spades, R.drawable.eight_spades, R.drawable.nine_spades, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
/* Hearts */ R.drawable.placeholder, R.drawable.two_hearts, R.drawable.three_hearts, R.drawable.four_hearts, R.drawable.five_hearts, R.drawable.six_hearts, R.drawable.seven_hearts, R.drawable.eight_hearts, R.drawable.nine_hearts, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
/* Clubs  */ R.drawable.placeholder, R.drawable.two_clubs, R.drawable.three_clubs, R.drawable.four_clubs, R.drawable.five_clubs, R.drawable.six_clubs, R.drawable.seven_clubs, R.drawable.eight_clubs, R.drawable.nine_clubs, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
/*Diamonds*/ R.drawable.placeholder, R.drawable.two_diamonds, R.drawable.three_diamonds, R.drawable.four_diamonds, R.drawable.five_diamonds, R.drawable.six_diamonds, R.drawable.seven_diamonds, R.drawable.eight_diamonds, R.drawable.nine_diamonds, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder)

    val cardIsTakenList = mutableListOf(false,
        false, false, false, false, false, false, false, false, false, false, false, false, false,
        false, false, false, false, false, false, false, false, false, false, false, false, false,
        false, false, false, false, false, false, false, false, false, false, false, false, false,
        false, false, false, false, false, false, false, false, false, false, false, false, false)

    private var _chipCount = 0
    val chipCount: Int
        get() = _chipCount

    private var _playerCount = 0
    val playerCount: Int
        get() = _playerCount

    fun setChipCount(newVal: Int) {
        _chipCount = newVal
        Log.i("CHIP", "ChipCount is now $_chipCount")
    }

    fun setPlayerCount(newVal: Int) {
        _playerCount = newVal
        Log.i("PLAYER", "PlayerCount is now $_playerCount")
    }

    fun getImgSrc(index: Int) : Int {
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
        _selectTypeToggle = false
        _chipCount = 0
        _playerCount = 0
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
                _handCardTwoImgRsc = cardResourceList[newVal]
                _handCardTwoIndex = newVal
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

    //----------------------------
    //CARD SELECTION VARS
    //----------------------------

    //FALSE IS HAND, TRUE IS FLOP
    private var _selectTypeToggle = false
    val selectTypeToggle: Boolean
        get() = _selectTypeToggle

    fun updateSelectTypeToggle(newVal: Boolean) {
        _selectTypeToggle = newVal
    }
}