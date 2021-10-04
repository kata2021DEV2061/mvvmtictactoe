package com.dev2061.mvvmtictactoe.model

import androidx.lifecycle.MutableLiveData

class Board {

    var winner = MutableLiveData<Player>()
    var squares = Array<Array<Square?>>(BOARD_SIZE) { arrayOfNulls(size = BOARD_SIZE) }
    var currentPlayer: Player? = Player.X

    fun checkEndGame(): Boolean {
        if (checkIfSquaresIdenticalInColumn() || checkIfSquaresIdenticalInRow() || checkIfSquaresIdenticalDiagonal()) {
            winner.value = currentPlayer
            return true
        }

        if (areAllSquaresFilledIn()) {
            winner.value = Player.NA
            return true
        }
        return false
    }


    fun changePlayer() {
        currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
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

    private fun checkIfSquaresIdentical(vararg squares: Square?) =
        (1 until squares.size).none { squares[0] == null || squares[0] != squares[it] }

    fun areAllSquaresFilledIn() = squares.all { it.all { it != null } }

    companion object {
        private const val BOARD_SIZE = 3
    }

}