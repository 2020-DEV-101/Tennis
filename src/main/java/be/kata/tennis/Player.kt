package be.kata.tennis

import be.kata.tennis.Score.*

internal class Player{
    private val scoreList = listOf(LOVE, FIFTEEN, THIRTY, FORTY)
    private val scoreIterator = scoreList.listIterator(0)

    var score = scoreIterator.next()
    var hasWon = false

    fun scorePoint(){
        when(score){
            FORTY -> hasWon = true
            DEUCE -> score = ADVANTAGE
            ADVANTAGE -> hasWon = true
            else -> score = scoreIterator.next()
        }

    }
}