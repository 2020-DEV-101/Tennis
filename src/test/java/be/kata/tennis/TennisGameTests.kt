package be.kata.tennis

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class TennisGameTests {

    private val tennisGame = TennisGame()

    @Test
    fun `A player's score should start at love`() {

        assertThat(tennisGame.playerOne.score.value, `is`(equalTo("0")))
        assertThat(tennisGame.playerTwo.score.value, `is`(equalTo("0")))
    }

    @Test
    fun `When a player is at love and scores, they should have fifteen points`() {
        tennisGame.playerOneScores()

        assertThat(tennisGame.playerOne.score.value, `is`(equalTo("15")))
    }

    @Test
    fun `When a player scores twice, they should have thirty points`() {
        repeat(2) { tennisGame.playerOneScores() }

        assertThat(tennisGame.playerOne.score.value, `is`(equalTo("30")))
    }

    @Test
    fun `When a player scores three times, they should have forty points`() {
        repeat(3) { tennisGame.playerOneScores() }

        assertThat(tennisGame.playerOne.score.value, `is`(equalTo("40")))
    }

    @Test
    fun `When a player has forty points and scores, they win the game`() {
        tennisGame.playerOne.score = Score.FORTY
        tennisGame.playerOneScores()

        assertThat(tennisGame.playerOne.hasWon, `is`(true))
    }

    @Test
    fun `When the player is at deuce and they score, they gain advantage`() {
        tennisGame.playerOne.score = Score.DEUCE
        tennisGame.playerOneScores()

        assertThat(tennisGame.playerOne.score.value, `is`("advantage"))
    }

    @Test
    fun `When the player is at advantage and they score, they win the game`() {
        tennisGame.playerOne.score = Score.ADVANTAGE
        tennisGame.playerOneScores()

        assertThat(tennisGame.playerOne.hasWon, `is`(true))
    }

    @Test
    fun `When both players of a game have 40 points, they are at deuce`() {
        tennisGame.playerOne.score = Score.THIRTY
        tennisGame.playerTwo.score = Score.FORTY


        tennisGame.playerOneScores()

        assertThat(tennisGame.playerOne.score.value, `is`(equalTo("deuce")))
        assertThat(tennisGame.playerTwo.score.value, `is`(equalTo("deuce")))
    }

}