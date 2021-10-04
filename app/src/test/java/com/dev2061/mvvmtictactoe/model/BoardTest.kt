package com.dev2061.mvvmtictactoe.model

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BoardTest {

    lateinit var board: Board

    @Before
    fun setup() {
        board = Board()
    }

    @Test
    fun Verify_whenChangePlayer_OtherSymbolIsBeingReturned() {
        //Arrange
        board.currentPlayer = Player.CROSS
        //Act
        board.changePlayer()
        //Assert
        assertEquals(Player.NOUGHT, board.currentPlayer)
    }

    @Test
    fun Verify_WhenStartUp_CrossIsBeingReturned() {
        //Arrange
        //Act
        //Assert
        assertEquals(Player.CROSS, board.currentPlayer)
    }

    @Test
    fun Verify_VerticalSquares_WhenAllTheSame() {
        //Arrange
        val square = Square(Player.CROSS)
        board.squares[0][1] = square
        board.squares[1][1] = square
        board.squares[2][1] = square
        //Act
        val actualResult: Boolean = board.checkIfSquaresIdenticalInColumn()
        //Assert
        Assert.assertTrue(actualResult)
    }

    @Test
    fun Verify_HorizontalSquares_WhenAllTheSame() {
        //Arrange
        val square = Square(Player.CROSS)
        board.squares[0][0] = square
        board.squares[0][1] = square
        board.squares[0][2] = square
        //Act
        val actualResult: Boolean = board.checkIfSquaresIdenticalInRow()
        //Assert
        Assert.assertTrue(actualResult)
    }

    @Test
    fun Verify_DiagonalSquares_WhenAllTheSame() {
        //Arrange
        val square = Square(Player.CROSS)
        board.squares[0][0] = square
        board.squares[1][1] = square
        board.squares[2][2] = square
        //Act
        val actualResult = board.checkIfSquaresIdenticalDiagonal()
        //Assert
        Assert.assertTrue(actualResult)
    }

}