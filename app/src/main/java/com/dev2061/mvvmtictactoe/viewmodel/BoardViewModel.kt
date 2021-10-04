package com.dev2061.mvvmtictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.ViewModel
import com.dev2061.mvvmtictactoe.model.Board
import com.dev2061.mvvmtictactoe.model.Player
import com.dev2061.mvvmtictactoe.model.Square

class BoardViewModel : ViewModel() {

    lateinit var squares: ObservableArrayMap<String, Player>
    lateinit var board: Board

    fun getWinner() = board.winner

    fun startGame() {
        squares = ObservableArrayMap()
        board = Board()
    }

    fun onBoardSquareClicked(row: Int, column: Int) {
        if (null == board.squares[row][column]) {
            board.squares[row][column] = Square(board.currentPlayer)
            val appendedString = appendString(row, column)
            squares[appendedString] = board.currentPlayer

            if (!board.checkEndGame()) {
                board.changePlayer()
            }
        }
    }
}

//With this function all the input digits are being appended into 1 string
fun appendString(vararg digits: Int) = digits.joinTo(StringBuilder(), separator = "").toString()