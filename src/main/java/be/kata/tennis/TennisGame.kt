package be.kata.tennis

import be.kata.tennis.Score.DEUCE

internal class TennisGame(private val playerOne: Player, private val playerTwo: Player) {

    var isDeuce = false
        get() = (playerOne.score == DEUCE && playerTwo.score == DEUCE)
        set(value) {
            if (value){
                playerOne.score = DEUCE
                playerTwo.score = DEUCE
            }
            field = value
        }

    // I wrote these two score functions so that only playerOne and playerTwo can score. giving a clear api.
    fun playerOneScores() {
        playerScores(playerOne)
    }

    fun playerTwoScores() {
        playerScores(playerTwo)
    }

    private fun playerScores(player: Player) {
        player.scorePoint()
        checkForDeuce()
    }

    private fun checkForDeuce() {
        if (playerOne.score == playerTwo.score
                && playerOne.score == Score.FORTY
                && playerTwo.score == Score.FORTY) {
            playerOne.score = DEUCE
            playerTwo.score = DEUCE
            isDeuce = true
        }
    }
}