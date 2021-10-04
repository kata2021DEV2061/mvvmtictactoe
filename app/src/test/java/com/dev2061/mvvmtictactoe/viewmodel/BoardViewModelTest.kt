package com.dev2061.mvvmtictactoe.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dev2061.mvvmtictactoe.model.Player
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BoardViewModelTest {

    private lateinit var vm: BoardViewModel

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        vm = BoardViewModel()
        vm.startGame()
    }

    @Test
    fun Verify_ChangePlayer() {
        //Arrange

        //Act
        vm.onBoardSquareClicked(0, 0)
        vm.onBoardSquareClicked(1, 0)
        //Assert
        Assert.assertEquals(Player.O.name, vm.squares["10"])
    }

    @Test
    fun Verify_CurrentPlayer_WhenStartGame() {
        //Arrange

        //Act
        vm.onBoardSquareClicked(0, 1)
        //Assert
        Assert.assertEquals(Player.X.name, vm.squares["01"])
    }

    @Test
    fun Verify_OverrideSquareNotPossible() {
        //Arrange

        //Act
        vm.onBoardSquareClicked(2, 2)
        vm.onBoardSquareClicked(2, 2)
        //Assert
        Assert.assertEquals(Player.X.name, vm.squares["22"])
    }

    @Test
    fun Verify_HasWinnerNought() {
        vm.onBoardSquareClicked(2, 0)
        vm.onBoardSquareClicked(1, 1)
        vm.onBoardSquareClicked(2, 1)
        vm.onBoardSquareClicked(1, 2)
        vm.onBoardSquareClicked(0, 2)
        vm.onBoardSquareClicked(1, 0)
        vm.getWinner()
        assertEquals(Player.O.name, vm.board.winner.value.toString())
    }

}