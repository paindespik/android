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
        nbAllumettes.text = nb.toString()
        joueurEnCours=player1
        aKiLeTour.text=joueurEnCours

    }

    fun nextPlayer(button: View){

        if(nb>0){
            var retirer=nbARetirer.text.toString().toInt()
            if (retirer>0 ){
                nb-=retirer
            }
            if(nb<=0){
                aKiLeTour.text="${joueurEnCours} a perdu"
            }
            nbAllumettes.text=nb.toString()
            if(joueurEnCours==player1){
                joueurEnCours=player2
            }
            else
                joueurEnCours=player1
            aKiLeTour.text=joueurEnCours
        }

    }
}
