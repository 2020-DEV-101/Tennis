package be.kata.tennis

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class PlayerTests {

    @Test
    fun `A player should start at 0 points`() {
        val player = Player()

        assertThat(player.score.value, `is`(equalTo("0")))
    }

    @Test
    fun `When a player scores, they should have 15 points`() {
        val player = Player()
        player.scorePoint()

        assertThat(player.score.value, `is`(equalTo("15")))
    }

    @Test
    fun `When a player scores twice, they should have 30 points`() {
        val player = Player()
        repeat(2) { player.scorePoint() }

        assertThat(player.score.value, `is`(equalTo("30")))
    }

    @Test
    fun `When a player scores three times, they should have 40 points`() {
        val player = Player()
        repeat(3) { player.scorePoint() }

        assertThat(player.score.value, `is`(equalTo("40")))
    }

    @Test
    fun `When a player has 40 points and scores, they win the game`() {
        val player = Player()

        repeat(4) { player.scorePoint() }
        assertThat(player.hasWon, `is`(true))
    }

}