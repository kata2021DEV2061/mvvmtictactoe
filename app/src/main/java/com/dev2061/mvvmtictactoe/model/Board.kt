package com.dev2061.mvvmtictactoe.model

class Board {

    var squares = Array<Array<Square?>>(BOARD_SIZE) { arrayOfNulls(size = BOARD_SIZE) }
    var currentPlayer: Player? = Player.CROSS

    fun changePlayer() {
        when (currentPlayer) {
            Player.CROSS -> currentPlayer = Player.NOUGHT
            Player.NOUGHT -> currentPlayer = Player.CROSS
        }
    }

    companion object {
        private const val BOARD_SIZE = 3
    }

}