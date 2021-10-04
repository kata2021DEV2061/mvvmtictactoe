package com.dev2061.mvvmtictactoe.viewmodel

import com.dev2061.mvvmtictactoe.model.Player
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BoardViewModelTest {

    private lateinit var vm: BoardViewModel

    @Before
    fun setup(){
        vm = BoardViewModel()
        vm.startGame()
    }

    @Test
    fun Verify_ChangePlayer() {
        //Arrange

        //Act
        vm.onBoardSquareClicked(0,0)
        vm.onBoardSquareClicked(1,0)
        //Assert
        Assert.assertEquals(Player.NOUGHT, vm.squares["10"])
    }

    @Test
    fun Verify_CurrentPlayer_WhenStartGame() {
        //Arrange

        //Act
        vm.onBoardSquareClicked(0, 1)
        //Assert
        Assert.assertEquals(Player.CROSS, vm.squares["01"])
    }

    @Test
    fun Verify_OverrideSquareNotPossible() {
        //Arrange

        //Act
        vm.onBoardSquareClicked(2,2)
        vm.onBoardSquareClicked(2,2)
        //Assert
        Assert.assertEquals(Player.CROSS, vm.squares["22"])
    }

}