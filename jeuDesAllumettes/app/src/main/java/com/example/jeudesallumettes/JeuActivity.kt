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
    var game1 = game();
    var AI:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jeu)
        player1 = intent.getStringExtra("player1")
        player2 = intent.getStringExtra("player2")
        AI=intent.getBooleanExtra("AI", false)
        if (AI){
            Description.text = "Against AI"
            player2="AI"
        }

        else
            Description.text="ONE VS ONE"
        nbAllumettes.text = "nombres allumettes : " + nb.toString()
        joueurEnCours=player1
        aKiLeTour.text=joueurEnCours

    }

    fun nextPlayer(button: View){
        var aRetirer:Int=0
        if(joueurEnCours==player1 || AI==false){
            if(button==retirer1)
                aRetirer=1
            else if (button==retirer2)
                aRetirer=2
            else
                aRetirer=3


        }

        else{
            
        }

        if(game1.retirerAllumettes(aRetirer,nb,player1,player2, joueurEnCours)==false)
        {
            aKiLeTour.text="${joueurEnCours} a perdu! quel nul!"
        }
        else{
            joueurEnCours=game1.getPlayer();
            aKiLeTour.text=joueurEnCours;
        }

        joueurEnCours=game1.getPlayer();
        nb=game1.getNb();
        nbAllumettes.text="nombres allumettes : " + nb.toString()




    }

    fun recommencer(button: View){
        nb=20;
        aKiLeTour.text=joueurEnCours;
        nbAllumettes.text="nombres allumettes : " + nb.toString();
    }



}
