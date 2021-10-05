package com.dev2061.mvvmtictactoe.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dev2061.mvvmtictactoe.R
import com.dev2061.mvvmtictactoe.databinding.ActivityMainBinding
import com.dev2061.mvvmtictactoe.model.Player
import com.dev2061.mvvmtictactoe.viewmodel.BoardViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var vm: BoardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initiateCleanBoard()
    }

    private fun initiateCleanBoard() {
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm = ViewModelProvider(this).get(BoardViewModel::class.java)
        vm.startGame()
        binding.vm = vm
        vm.getWinner().observe(this, Observer<Player> {
            if (it.name == Player.NA.toString()) {
                showAlertDialog(DRAW)
            } else {
                showAlertDialog(it.name)
            }

        })
    }

    private fun showAlertDialog(result: String) {
        lateinit var message: String
        if(result == DRAW){
            message = "It's a draw"
        }else{
            message = "$result won"
        }
        AlertDialog.Builder(this)
            .setTitle(message)
            .setCancelable(false)
            .setPositiveButton("Replay") { _, _ ->
                initiateCleanBoard()
            }
            .show()
    }

    companion object {
        private const val DRAW = "draw"
    }
}