package be.kata.tennis

internal class Player{

    var score = 0

    private val scoreList = listOf(Score.LOVE, Score.FIFTEEN, Score.THIRTY, Score.FORTY)
    private val scoreIterator = scoreList.listIterator(0)

    init {
        score = scoreIterator.next().value
    }

    fun scorePoint(){
        score = scoreIterator.next().value
    }
}