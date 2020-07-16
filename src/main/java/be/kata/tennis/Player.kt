package be.kata.tennis

internal class Player{

    var score = 0
    var hasWon = false
    var isDeuce = false

    private val scoreList = listOf(Score.LOVE, Score.FIFTEEN, Score.THIRTY, Score.FORTY)
    private val scoreIterator = scoreList.listIterator(0)

    init {
        score = scoreIterator.next().value
    }

    fun scorePoint(){
        if (score == Score.FORTY.value) {
            hasWon = true
        } else
        {
            score = scoreIterator.next().value
        }
    }
}