package be.kata.tennis

import java.awt.EventQueue
import javax.swing.*
import javax.swing.SwingConstants.LEADING

// Code based mostly on http://zetcode.com/kotlin/swing/.
internal class TennisUI : JFrame() {

    var playerOneScoreLbl: JLabel
    var playerTwoScoreLbl: JLabel
    var playerOneHasWonLbl: JLabel
    var playerTwohasWonLbl: JLabel
    lateinit var winnerLbl: JLabel

    init {
        var tennisGame = TennisGame()
        var playerOne = tennisGame.playerOne
        var playerTwo = tennisGame.playerTwo
        title = "Tennis game"

        val resetBtn = JButton("Reset game").apply {
            addActionListener {
                tennisGame = TennisGame()
                playerOne = tennisGame.playerOne
                playerTwo = tennisGame.playerTwo
                updatePlayerLabels(playerOne, playerTwo)
                winnerLbl.text = ""
            }
        }
        val playerOneScoreBtn = JButton("Player One scores").apply {
            addActionListener {
                tennisGame.playerOneScores()
                updatePlayerLabels(playerOne, playerTwo)
                updateWinnerLabel(tennisGame)
            }
        }
        val playerTwoScoreBtn = JButton("Player Two scores").apply {
            addActionListener {
                tennisGame.playerTwoScores()
                updatePlayerLabels(playerOne, playerTwo)
                updateWinnerLabel(tennisGame)
            }
        }

        playerOneScoreLbl = JLabel("P1 Score: ${playerOne.score.name}", null, LEADING)
        playerTwoScoreLbl = JLabel("P2 Score: ${playerTwo.score.name}", null, LEADING)

        playerOneHasWonLbl = JLabel("P1 has won: ${playerOne.hasWon}", null, LEADING)
        playerTwohasWonLbl = JLabel("P2 has won: ${playerTwo.hasWon}", null, LEADING)

        winnerLbl = JLabel("", null, LEADING)

        createLayout(playerOneScoreBtn, playerTwoScoreBtn,
                playerOneScoreLbl, playerTwoScoreLbl,
                playerOneHasWonLbl, playerTwohasWonLbl,
                resetBtn,
                winnerLbl)

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(500, 300)
        setLocationRelativeTo(null)
    }

    private fun updatePlayerLabels(playerOne: Player, playerTwo: Player) {
        playerOneScoreLbl.text = "P1 Score: ${playerOne.score.name}"
        playerTwoScoreLbl.text = "P2 Score: ${playerTwo.score.name}"

        playerOneHasWonLbl.text = "P1 has won: ${playerOne.hasWon}"
        playerTwohasWonLbl.text = "P2 has won: ${playerTwo.hasWon}"
    }

    private fun updateWinnerLabel(tennisGame: TennisGame) {
        if (tennisGame.playerOne.hasWon) {
            winnerLbl.text = "The winner is player one!"
            winnerLbl.font = font.deriveFont(40f)
        } else if (tennisGame.playerTwo.hasWon) {
            winnerLbl.text = "The winner is player two!"
            winnerLbl.font = font.deriveFont(40f)
        }
    }


    private fun createLayout(vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true
        gl.autoCreateGaps = true

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1])
                )
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[2])
                        .addComponent(arg[3]))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[4])
                        .addComponent(arg[5]))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[6]))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[7]))
        )

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1])
                )
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[2])
                        .addComponent(arg[3]))
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[4])
                        .addComponent(arg[5]))
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[6]))
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[7]))
        )

        pack()
    }

}

private fun createAndShowGUI() {

    TennisUI().isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}