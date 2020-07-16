package be.kata.tennis

// sealed class playerOne and playerTwo? ==> not really needed
// val or var? Let's go with var, in this tennis game it makes more sense to update the score than to change the players.
internal data class Player(var score: Score, var hasWon: Boolean)
