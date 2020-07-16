package be.kata.tennis

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TennisTests {

    @Test
    fun `A player should start at 0 points`() {
        val playerOne = Player()

        assertThat(playerOne.score, `is`(equalTo(0)))
    }

    @Test
    fun `When a player scores, they should have 15 points`() {
        val playerOne = Player()
        playerOne.scorePoint()

        assertThat(playerOne.score, `is`(equalTo(15)))
    }

    @Test
    fun `When a player scores twice, they should have 30 points`() {
        val playerOne = Player()
        repeat(2) { playerOne.scorePoint() }

        assertThat(playerOne.score, `is`(equalTo(30)))
    }

    @Test
    fun `When a player scores three times, they should have 40 points`() {
        val playerOne = Player()
        repeat(3) { playerOne.scorePoint() }

        assertThat(playerOne.score, `is`(equalTo(40)))
    }

    @Test
    fun `When a player has 40 points and scores, they win the game`() {
        val playerOne = Player()

        repeat(4) { playerOne.scorePoint() }
        assertThat(playerOne.hasWon, `is`(true))
    }

    @Test
    fun `When both players of a game have 40 points, they are at deuce`() {
        val playerOne = Player()
        val playerTwo = Player()
        val game = TennisGame(playerOne, playerTwo)

        repeat(3) { game.playerOneScores() }
        repeat(3) { game.playerTwoScores() }
        assertThat(playerOne.score, `is`(equalTo(40)))
        assertThat(playerTwo.score, `is`(equalTo(40)))
        assertThat(playerOne.isDeuce, `is`(true))
        assertThat(playerTwo.isDeuce, `is`(true))
        assertThat(game.isDeuce, `is`(true))

    }

}