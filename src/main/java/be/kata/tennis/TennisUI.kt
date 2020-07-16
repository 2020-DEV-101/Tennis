package be.kata.tennis

import java.awt.EventQueue
import javax.swing.*
import javax.swing.SwingConstants.LEADING

// Code based mostly on http://zetcode.com/kotlin/swing/.
internal class TennisUI : JFrame() {

    var playerOneScoreLbl: JLabel
    var playerTwoScoreLbl : JLabel
    var playerOneIsDeuceLbl : JLabel
    var playerTwoIsDeuceLbl : JLabel
    var playerOneHasWonLbl : JLabel
    var playerTwohasWonLbl : JLabel

    init {
        var playerOne = Player()
        var playerTwo = Player()
        var tennisGame = TennisGame(playerOne, playerTwo)
        title = "Tennis game"

        val resetBtn = JButton("Reset game").apply {
            addActionListener {
                playerOne = Player()
                playerTwo = Player()
                tennisGame = TennisGame(playerOne, playerTwo)
                updatePlayerLabels(playerOne, playerTwo)
            }
        }
        val playerOneScoreBtn = JButton("Player One scores").apply {
            addActionListener {
                tennisGame.playerOneScores()
                updatePlayerLabels(playerOne, playerTwo)
            }
        }
        val playerTwoScoreBtn = JButton("Player Two scores").apply {
            addActionListener {
                tennisGame.playerTwoScores()
                updatePlayerLabels(playerOne, playerTwo)
            }
        }

        playerOneScoreLbl = JLabel("P1 Score: ${playerOne.score.name}", null, LEADING)
        playerTwoScoreLbl = JLabel("P2 Score: ${playerTwo.score.name}", null, LEADING)

        playerOneIsDeuceLbl = JLabel("P1 is deuce: ${playerOne.isDeuce}", null, LEADING)
        playerTwoIsDeuceLbl = JLabel("P2 is deuce: ${playerTwo.isDeuce}", null, LEADING)

        playerOneHasWonLbl = JLabel("P1 has won: ${playerOne.hasWon}", null, LEADING)
        playerTwohasWonLbl = JLabel("P2 has won: ${playerTwo.hasWon}", null, LEADING)

        createLayout(playerOneScoreBtn, playerTwoScoreBtn,
                playerOneScoreLbl, playerTwoScoreLbl,
                playerOneIsDeuceLbl, playerTwoIsDeuceLbl,
                playerOneHasWonLbl, playerTwohasWonLbl,
                resetBtn)

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(500, 300)
        setLocationRelativeTo(null)
    }

    private fun updatePlayerLabels(playerOne: Player, playerTwo: Player) {
        playerOneScoreLbl.text = "P1 Score: ${playerOne.score.name}"
        playerTwoScoreLbl.text = "P2 Score: ${playerTwo.score.name}"

        playerOneIsDeuceLbl.text = "P1 is deuce: ${playerOne.isDeuce}"
        playerTwoIsDeuceLbl.text = "P2 is deuce: ${playerTwo.isDeuce}"

        playerOneHasWonLbl.text = "P1 has won: ${playerOne.hasWon}"
        playerTwohasWonLbl.text = "P2 has won: ${playerTwo.hasWon}"
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
                        .addComponent(arg[6])
                        .addComponent(arg[7]))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[8])
                )
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
                        .addComponent(arg[6])
                        .addComponent(arg[7]))
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[8]))
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