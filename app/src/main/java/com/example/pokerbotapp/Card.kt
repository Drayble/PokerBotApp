package com.example.pokerbotapp


/*
HELP AT THE TOP OF THE PAGE:
https://kotlinlang.org/docs/nested-classes.html
 */

class Card(
    val num: Int,
    val suit: String = when (num) {
        in 1..13 -> "beans"
        in 14..26 -> "beans"
        in 27..39 -> "beans"
        in 40..52 -> "beans"
        else -> "Invalid num was entered when creating the card"
    },
    val numericValue: Int = num,
    val chenVal: Double = LogicSystem.CardCreationMethods().createChenVal()
    ) {
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
//    private var chenVal: Double? = 0.0
//    //NOTICE: THIS STRING IS FOR PRINTING ONLY
//    private var cardNumLetValue: String? = "No cardNumLetValue Set"

}