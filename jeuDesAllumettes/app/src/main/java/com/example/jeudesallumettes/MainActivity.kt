package com.example.jeudesallumettes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun confirmButtonTouched(button:View){
        val player1=input1.text
        val player2=input2.text
        val intent = Intent(this, JeuActivity::class.java)
        intent.putExtra("player1", player1).putExtra("player2", player2)
        startActivity(intent)
    }
}