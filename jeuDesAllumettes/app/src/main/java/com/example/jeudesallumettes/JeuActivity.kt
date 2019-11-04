package com.example.jeudesallumettes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import kotlinx.android.synthetic.main.activity_jeu.*

class JeuActivity : AppCompatActivity() {
    var nb=20;
    var joueurEnCours:String?=""
    var player1:String?=""
    var player2:String?=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jeu)
        player1 = intent.getStringExtra("player1")
        player2 = intent.getStringExtra("player2")
        nbAllumettes.text = "nombres allumettes : " + nb.toString()
        joueurEnCours=player1
        aKiLeTour.text=joueurEnCours

    }

    fun nextPlayer(button: View){
        var aRetirer=0
        if(button==retirer1)
            aRetirer=1
        else if (button==retirer2)
            aRetirer=2
        else
            aRetirer=3
        if(retirerAllumettes(aRetirer)==false)
        {
            aKiLeTour.text="${joueurEnCours} a perdu! quel nul!"
        }
        else
            nbAllumettes.text="nombres allumettes : " + nb.toString()


    }
    fun retirerAllumettes(num:Int):Boolean{
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
            return false

        }
        return false
    }


}
