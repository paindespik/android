package com.example.jeudesallumettes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import kotlinx.android.synthetic.main.activity_jeu.*

class game : AppCompatActivity() {


    private var nb=0;
    private var joueurEnCours:String?=""
    private var player1:String?=""
    private var player2:String?=""
    fun retirerAllumettes(num:Int, nball:Int, play1:String?, play2:String?, JoueurEnCours:String?):Boolean{
        player1=play1;
        player2=play2;
        joueurEnCours=JoueurEnCours
        nb=nball;
        if(nb>0){
            nb-=num
            if(nb>0)
            {
                if (joueurEnCours==player1)
                    joueurEnCours=player2
                else
                    joueurEnCours=player1

                return true
            }
            nb=0
            return false

        }
        return false
    }

    fun getNb():Int{
        return nb;
    }

    fun getPlayer():String?{
        return joueurEnCours;
    }
}