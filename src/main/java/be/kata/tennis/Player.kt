package be.kata.tennis

internal class Player{
    private val scoreList = listOf(Score.LOVE, Score.FIFTEEN, Score.THIRTY, Score.FORTY)
    private val scoreIterator = scoreList.listIterator(0)

    var score = scoreIterator.next()
    var hasWon = false

    fun scorePoint(){
        if (score == Score.FORTY) {
            hasWon = true
        } else
        {
            score = scoreIterator.next()
        }
    }
}