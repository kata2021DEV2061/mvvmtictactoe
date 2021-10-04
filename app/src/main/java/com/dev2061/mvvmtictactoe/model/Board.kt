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

    fun checkIfSquaresIdenticalInColumn(): Boolean {
        for (i in 0 until BOARD_SIZE)
            if (checkIfSquaresIdentical(squares[0][i], squares[1][i], squares[2][i])) {
                return true
            }
        return false
    }

    fun checkIfSquaresIdenticalInRow(): Boolean {
        for (i in 0 until BOARD_SIZE)
            if (checkIfSquaresIdentical(squares[i][0], squares[i][1], squares[i][2])) {
                return true
            }
        return false
    }

    fun checkIfSquaresIdenticalDiagonal(): Boolean {
        return checkIfSquaresIdentical(squares[0][0], squares[1][1], squares[2][2]) ||
                checkIfSquaresIdentical(squares[0][2], squares[1][1], squares[2][0])
    }


    private fun checkIfSquaresIdentical(vararg squares: Square?): Boolean {
        val square = squares[0]
        for (i in 1 until squares.size)
            if (square == null || square != squares[i])
                if (square != squares[i])
                    return false
        return true
    }

    companion object {
        private const val BOARD_SIZE = 3
    }

}