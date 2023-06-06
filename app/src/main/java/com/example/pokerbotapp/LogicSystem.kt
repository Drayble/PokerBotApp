package com.example.pokerbotapp

import kotlin.math.abs

class LogicSystem {
    class GlobalMethods {
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

        }
        class OnePairMethods {

        }
        class TwoPairMethods {

        }
        class ThreeOfAKindMethods {

        }
        class StraightMethods {

        }
        class FlushMethods {

        }
        class FullHouseMethods {

        }
        class FourOfAKindMethods {

        }
        class StraightFlushMethods {

        }
    }
}