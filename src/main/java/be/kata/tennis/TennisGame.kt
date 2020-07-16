package be.kata.tennis

import be.kata.tennis.Score.*

internal class TennisGame {
    val playerOne = Player(score = LOVE, hasWon = false)
    val playerTwo = Player(score = LOVE, hasWon = false)

    // I wrote these two score functions so that only playerOne and playerTwo can score. giving a clear api.
    fun playerOneScores() {
        playerScores(playerOne, playerTwo)
    }

    fun playerTwoScores() {
        playerScores(playerTwo, playerOne)
    }

    private fun playerScores(player: Player, opponent: Player) {
        if (!playerOne.hasWon && !playerTwo.hasWon) {
            calculateScores(player, opponent)
        }
    }

    private fun calculateScores(player: Player, opponent: Player) {
        when (player.score) {
            LOVE -> player.score = FIFTEEN
            FIFTEEN -> player.score = THIRTY
            THIRTY -> when (opponent.score) {
                FORTY -> setDeuce(player, opponent)
                else -> player.score = FORTY
            }
            FORTY -> when (opponent.score) {
                ADVANTAGE -> setDeuce(player, opponent)
                else -> {
                    player.hasWon = true
                }
            }
            DEUCE -> {
                player.score = ADVANTAGE
                opponent.score = FORTY
            }
            ADVANTAGE -> player.hasWon = true
        }
    }

    private fun setDeuce(player: Player, opponent: Player) {
        player.score = DEUCE
        opponent.score = DEUCE
    }
}