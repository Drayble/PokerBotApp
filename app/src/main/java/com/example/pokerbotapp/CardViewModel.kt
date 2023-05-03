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

    //----------------------------
    //HAND VARIABLES AND FUNCTIONS
    //----------------------------
    private var _handCardOneVal = MutableLiveData(0)
    val handCardOneVal: LiveData<Int>
        get() = _handCardOneVal

    private var _handCardTwoVal = MutableLiveData(0)
    val handCardTwoVal: LiveData<Int>
        get() = _handCardTwoVal

    fun setBothCardVals(newVal: Int) {
        _handCardOneVal.value = newVal
        _handCardTwoVal.value = newVal
    }

}