package be.kata.tennis

internal class TennisGame(private val playerOne: Player, private val playerTwo: Player) {

    var isDeuce = false
    get() = (playerOne.isDeuce && playerTwo.isDeuce)
    set(value) {
        playerOne.isDeuce = value
        playerTwo.isDeuce = value
        field = value
    }

    // I wrote these two score functions so that only playerOne and playerTwo can score. giving a clear api.
    fun playerOneScores(){
        playerScores(playerOne)
    }

    fun playerTwoScores(){
        playerScores(playerTwo)
    }

    private fun playerScores(player: Player){
        player.scorePoint()
        checkForDeuce()
    }

    private fun checkForDeuce() {
        if (playerOne.score == playerTwo.score
                && playerOne.score == Score.FORTY.value
                && playerTwo.score == Score.FORTY.value){
            playerOne.isDeuce = true
            playerOne.isDeuce = true
            isDeuce = true
        }
    }
}