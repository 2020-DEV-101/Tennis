package be.kata.tennis

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

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

}