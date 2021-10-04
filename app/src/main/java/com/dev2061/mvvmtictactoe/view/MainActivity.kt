package com.dev2061.mvvmtictactoe.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm = ViewModelProvider(this).get(BoardViewModel::class.java)
        vm.startGame()
        binding.vm = vm
        vm.getWinner().observe(this, Observer<Player> {  })
    }
}