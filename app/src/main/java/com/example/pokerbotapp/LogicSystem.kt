package com.example.pokerbotapp

import kotlin.math.abs

class LogicSystem {
    class GlobalMethods {
        fun getBetLevelBasic (inputList: List<Card>): Int {
            //one pair
            if(HandMethods.OnePairMethods().checkForOnePair(inputList)) {
                return 2
            }
            else {
                //high card
                val list = HandMethods.HighCardMethods().sortByHighCard(inputList)
                return 1
            }
        }

        fun getDescriptionStatement(inputList: List<Card>): String {
            //one pair
            if(HandMethods.OnePairMethods().checkForOnePair(inputList)) {
                return "You have a pair of " + inputList[HandMethods.OnePairMethods().getOnePairIndex(inputList)].cardNumLetVal + "s"
            }
            else {
                //high card
                val list = HandMethods.HighCardMethods().sortByHighCard(inputList)
                return "You have a high card " + list[0].cardNumLetVal
            }
        }


        fun getBestHand(inputList: List<Card>): ArrayList<Card> {
            //one pair
            if(HandMethods.OnePairMethods().checkForOnePair(inputList)) {
                return HandMethods.OnePairMethods().getBestHandWithOnePair(inputList)
            }
            else {
                //high card
                return HandMethods.HighCardMethods().sortByHighCard(inputList)
            }
        }
//        fun getBestHand(inputList: List<Card>): ArrayList<Card> {
//            //straight flush
//            if(HandMethods.StraightFlushMethods().checkForStraightFlush(inputList)) {
//                return HandMethods.StraightFlushMethods().getBestHandWithStraightFlush(inputList)
//            }
//            else {
//                //four of a kind
//                if(HandMethods.FourOfAKindMethods().checkForFourOfAKind(inputList)) {
//                    return HandMethods.FourOfAKindMethods().getBestHandWithFourOfAKind(inputList)
//                }
//                else {
//                    //full house
//                    if(HandMethods.FullHouseMethods().checkForFullHouse(inputList)) {
//                        return HandMethods.FullHouseMethods().getBestHandWithFullHouse(inputList)
//                    }
//                    else {
//                        //flush
//                        if(HandMethods.FlushMethods().checkForFlush(inputList)) {
//                            return HandMethods.FlushMethods().getBestHandWithFlush(inputList)
//                        }
//                        else {
//                            //straight
//                            if(HandMethods.StraightMethods().checkForStraight(inputList)) {
//                                return HandMethods.StraightMethods().getBestHandWithStraight(inputList)
//                            }
//                            else {
//                                //three of a kind
//                                if(HandMethods.ThreeOfAKindMethods().checkForThreeOfAKind(inputList)) {
//                                    return HandMethods.ThreeOfAKindMethods().getBestHandWithThreeOfAKind(inputList)
//                                }
//                                else {
//                                    //two pair
//                                    if(HandMethods.TwoPairMethods().checkForTwoPair(inputList)) {
//                                        return HandMethods.TwoPairMethods().getBestHandWithTwoPair(inputList)
//                                    }
//                                    else {
//                                        //one pair
//                                        if(HandMethods.OnePairMethods().checkForOnePair(inputList)) {
//                                            return HandMethods.OnePairMethods().getBestHandWithOnePair(inputList)
//                                        }
//                                        else {
//                                            //high card
//                                            return HandMethods.HighCardMethods().sortByHighCard(inputList)
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
        fun getHighestChenValCard(cardList: List<Card>): Card {
            var card1 = cardList[0]
            var index = 1
            while (index < cardList.size) {
                val tempCard = cardList[index]
                if (tempCard.chenVal > card1.chenVal) {
                    card1 = tempCard
                }
                index++
            }
            return card1
        }
        fun getCardDifference(inputList: List<Card>):Int {
            val cardOne: Card = inputList[0]
            val cardTwo: Card = inputList[1]
            return abs(cardOne.numericValue - cardTwo.numericValue)
        }
    }
    class CardCreationMethods {
        fun createNumericValue(input: Int): Int {
            var newNum = input
            while (newNum > 13) {
                newNum -= 13
            }
            return newNum
        }
        fun createChenVal(numericVal: Int): Double {
            return when (numericVal) {
                0 -> 100.0
                1 -> 10.0
                in 2..10 -> numericVal/2.0
                11 -> 6.0
                12 -> 7.0
                13 -> 8.0
                else -> 69.0
            }
        }

    }
    class HandMethods {
        class StartingHandMethods {
            fun getStartingHandChenVal(card1: Card, card2: Card): Double {
                var totalValue = 0.0
                if (card1.numericValue == card2.numericValue) {
                    totalValue = card1.chenVal * 2
                    if (totalValue < 5) {
                        totalValue = 5.0
                    }
                } else {
                    totalValue += GlobalMethods().getHighestChenValCard(listOf(card1, card2)).chenVal
                    when (GlobalMethods().getCardDifference(listOf(card1, card2))) {
                        2 -> totalValue -= 1.0
                        3 -> totalValue -= 2.0
                        4 -> totalValue -= 4.0
                        5, 6, 7, 8, 9, 10, 11, 12 -> totalValue -= 5.0
                    }
                    if (GlobalMethods().getHighestChenValCard(listOf(card1, card2)).numericValue < 12 && GlobalMethods().getCardDifference(listOf(card1, card2)) <= 2) {
                        totalValue += 1.0
                    }
                    if (card1.suit == card2.suit) {
                        totalValue += 2.0
                    }
                }
                return totalValue
            }
        }
        class HighCardMethods {
            fun sortByHighCard(inputList: List<Card>): ArrayList<Card> {
                var returnList: ArrayList<Card> = arrayListOf<Card>()
                var masterIndex = 1
                returnList.add(inputList[0])
                while (masterIndex < inputList.size) {
                    val tempCardHolder = inputList[masterIndex]
                    var index = 0
                    while ((index < (returnList.size - 1)) && (tempCardHolder.numericSortValue <= returnList[index].numericSortValue)) {
                        index++
                    }
                    if (index < (returnList.size - 1)) {
                        returnList.add(index, tempCardHolder)
                    }
                    else {
                        returnList.add(tempCardHolder)
                    }
                    masterIndex++
                }
                return returnList
            }
        }
        //TODO: HOW TO MAKE THESE METHODS EASIER: SORT THE INPUT LIST BY CARD SORT VAL, AND THEN JUST GET ALL CARDS NEXT TO EACH OTHER AND YOU'LL GET MORE VALUABLE PAIRS FIRST
        class OnePairMethods {
            fun checkForOnePair(inputList: List<Card>): Boolean {
                var masterIndex = 0
                while (masterIndex < inputList.size) {
                    val checkCard = inputList[masterIndex]
                    var index = masterIndex + 1
                    while (index < inputList.size) {
                        if (checkCard.numericSortValue == inputList[index].numericSortValue) {
                            return true
                        }
                        index++
                    }
                    masterIndex++
                }
                return false
            }
            fun getOnePairIndex(inputList: List<Card>): Int {
                var masterIndex = 0
                while (masterIndex < inputList.size) {
                    val checkCard = inputList[masterIndex]
                    var index = masterIndex + 1
                    while (index < inputList.size) {
                        if (checkCard.numericValue == inputList[index].numericValue) {
                            return index
                        }
                        index++
                    }
                    masterIndex++
                }
                return 0
            }
            fun getBestHandWithOnePair(inputList: List<Card>): ArrayList<Card> {
                var returnList: ArrayList<Card> = arrayListOf<Card>()
                var pickList: ArrayList<Card> = arrayListOf<Card>()
                for (item in inputList) {
                    pickList.add(item)
                }
                val firstPart: Card = pickList.removeAt(getOnePairIndex(inputList))
                returnList.add(firstPart)
                var secondPart: Card
                var index = 0
                while (firstPart.numericValue != pickList[index].numericValue) {
                    index++
                }
                secondPart = pickList.removeAt(index)
                returnList.add(secondPart)
                for (i in 1..3) {
                    returnList.add(pickList.removeAt(0))
                }
                return returnList
            }
        }
//        class TwoPairMethods {
//            fun checkForTwoPair(inputList: List<Card>): Boolean {
//
//            }
//            fun getBestHandWithTwoPair(inputList: List<Card>): ArrayList<Card> {
//
//            }
//        }
//        class ThreeOfAKindMethods {
//            fun checkForThreeOfAKind(inputList: List<Card>): Boolean {
//
//            }
//            fun getBestHandWithThreeOfAKind(inputList: List<Card>): ArrayList<Card> {
//
//            }
//        }
//        class StraightMethods {
//            fun checkForStraight(inputList: List<Card>): Boolean {
//
//            }
//            fun getBestHandWithStraight(inputList: List<Card>): ArrayList<Card> {
//
//            }
//        }
//        class FlushMethods {
//            fun checkForFlush(inputList: List<Card>): Boolean {
//
//            }
//            fun getBestHandWithFlush(inputList: List<Card>): ArrayList<Card> {
//
//            }
//        }
//        class FullHouseMethods {
//            fun checkForFullHouse(inputList: List<Card>): Boolean {
//
//            }
//            fun getBestHandWithFullHouse(inputList: List<Card>): ArrayList<Card> {
//
//            }
//        }
//        class FourOfAKindMethods {
//            fun checkForFourOfAKind(inputList: List<Card>): Boolean {
//
//            }
//            fun getBestHandWithFourOfAKind(inputList: List<Card>): ArrayList<Card> {
//
//            }
//        }
//        class StraightFlushMethods {
//            fun checkForStraightFlush(inputList: List<Card>): Boolean {
//
//            }
//            fun getBestHandWithStraightFlush(inputList: List<Card>): ArrayList<Card> {
//
//            }
//        }
    }
}