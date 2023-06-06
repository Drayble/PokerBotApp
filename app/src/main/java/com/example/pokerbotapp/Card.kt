package com.example.pokerbotapp


/*
HELP AT THE TOP OF THE PAGE:
https://kotlinlang.org/docs/nested-classes.html
 */

/*
    EXAMPLE OF VARIABLE NOT SET BY PARAMETER

    val status: String
        get() =
            if (opened) {
                "Received"
            }
            else {
                "New Snap"
            }
     */

class Card(val creationNum: Int, val cardImgRsc: Int) {
    val getCardImgRsc: Int
        get() = cardImgRsc

    val suit: String
        get() = when (creationNum) {
            in 1..13 -> "Spades"
            in 14..26 -> "Hearts"
            in 27..39 -> "Clubs"
            in 40..52 -> "Diamonds"
            else -> "(suit var) Invalid num was entered when creating the card"
        }

    val numericValue: Int
        get() = LogicSystem.CardCreationMethods().createNumericValue(creationNum)

    val chenVal: Double
        get() = LogicSystem.CardCreationMethods().createChenVal(numericValue)

    val cardNumLetVal: String
        get() = when (numericValue) {
        1 -> "Ace"
        in 2..10 -> "" + numericValue + ""
        11 -> "Jack"
        12 -> "Queen"
        13 -> "King"
        else -> "(cardNumLetVal var) Invalid numericValue was entered when creating the card"
    }



}