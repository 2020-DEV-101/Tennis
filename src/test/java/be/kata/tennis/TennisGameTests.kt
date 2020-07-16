package be.kata.tennis

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class TennisGameTests {

    private val tennisGame = TennisGame()

    @Test
    fun `A player's score should start at love`() {

        assertThat(tennisGame.playerOne.score.name, `is`(equalTo("LOVE")))
        assertThat(tennisGame.playerTwo.score.name, `is`(equalTo("LOVE")))
    }

    @Test
    fun `When a player is at love and scores, they should have fifteen points`() {
        tennisGame.playerOneScores()

        assertThat(tennisGame.playerOne.score.name, `is`(equalTo("FIFTEEN")))
    }

    @Test
    fun `When a player scores twice, they should have thirty points`() {
        repeat(2) { tennisGame.playerOneScores() }

        assertThat(tennisGame.playerOne.score.name, `is`(equalTo("THIRTY")))
    }

    @Test
    fun `When a player scores three times, they should have forty points`() {
        repeat(3) { tennisGame.playerOneScores() }

        assertThat(tennisGame.playerOne.score.name, `is`(equalTo("FORTY")))
    }

    @Test
    fun `When a player has forty points and scores and the opponent has less than forty, they win the game`() {
        tennisGame.playerOne.score = Score.FORTY
        tennisGame.playerTwo.score = Score.THIRTY
        tennisGame.playerOneScores()

        assertThat(tennisGame.playerOne.hasWon, `is`(true))
    }

    @Test
    fun `When both players of a game have forty points, they are at deuce`() {
        tennisGame.playerOne.score = Score.THIRTY
        tennisGame.playerTwo.score = Score.FORTY


        tennisGame.playerOneScores()

        assertThat(tennisGame.playerOne.score.name, `is`(equalTo("DEUCE")))
        assertThat(tennisGame.playerTwo.score.name, `is`(equalTo("DEUCE")))
    }

    @Test
    fun `When the player is at deuce and they score, they gain advantage`() {
        tennisGame.playerOne.score = Score.DEUCE
        tennisGame.playerOneScores()

        assertThat(tennisGame.playerOne.score.name, `is`("ADVANTAGE"))
    }

    @Test
    fun `When the player is at advantage and they score, they win the game`() {
        tennisGame.playerOne.score = Score.ADVANTAGE
        tennisGame.playerOneScores()

        assertThat(tennisGame.playerOne.hasWon, `is`(true))
    }

}