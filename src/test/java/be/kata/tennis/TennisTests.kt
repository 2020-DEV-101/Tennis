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
    fun `A player can not score more than 40 points`() {
        val playerOne = Player()

        assertThrows<NoSuchElementException> {
            repeat(4) { playerOne.scorePoint() }
        }
    }

}