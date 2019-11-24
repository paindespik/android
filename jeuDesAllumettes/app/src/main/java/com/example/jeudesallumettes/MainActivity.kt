package com.example.jeudesallumettes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View.OnClickListener
import android.widget.CheckBox
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity(), OnClickListener {
     var AI:Boolean=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkBox.setOnClickListener(this)
        AI=false
    }
    fun confirmButtonTouched(button:View){
        val player1=input1.text.toString()
        val player2=input2.text.toString()

        val intent = Intent(this, JeuActivity::class.java)
        intent.putExtra("player1", player1).putExtra("player2", player2).putExtra("AI", AI)
        startActivity(intent)
    }
    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked:Boolean = v.isChecked

        when (v.id) {
            R.id.checkBox -> {
                AI = isChecked
                if (AI)
                    input2.isVisible=false
            }

        }

    }
}