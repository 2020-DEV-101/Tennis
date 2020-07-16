package be.kata.tennis

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class TennisGameTests {

    @Test
    fun `When both players of a game have 40 points, they are at deuce`() {
        val playerOne = Player()
        val playerTwo = Player()
        val game = TennisGame(playerOne, playerTwo)

        repeat(3) { game.playerOneScores() }
        repeat(3) { game.playerTwoScores() }
        assertThat(playerOne.score.value, `is`(equalTo(40)))
        assertThat(playerTwo.score.value, `is`(equalTo(40)))
        assertThat(playerOne.isDeuce, `is`(true))
        assertThat(playerTwo.isDeuce, `is`(true))
        assertThat(game.isDeuce, `is`(true))

    }

}