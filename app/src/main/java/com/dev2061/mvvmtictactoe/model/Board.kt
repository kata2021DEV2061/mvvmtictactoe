package com.dev2061.mvvmtictactoe.model

class Board {
    var currentPlayer: Player? = Player.CROSS

    fun changePlayer() {
        when (currentPlayer) {
            Player.CROSS -> currentPlayer = Player.NOUGHT
            Player.NOUGHT -> currentPlayer = Player.CROSS
        }
    }

}