package com.example.kotlindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory(application)
        ).get(MyViewModel::class.java)
        viewModel.number.observe(this, Observer{textView.text = it.toString()})

        btnPlus.setOnClickListener{
            viewModel.modifyNumber(1)
        }

        btnMinus.setOnClickListener{
            viewModel.modifyNumber(-1)
        }
    }
}
