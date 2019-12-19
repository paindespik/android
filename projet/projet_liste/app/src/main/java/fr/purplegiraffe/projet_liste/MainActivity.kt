package fr.purplegiraffe.projet_liste

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import fr.purplegiraffe.liste.Series
import fr.purplegiraffe.liste.SeriesAdapter
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var _realm:Realm


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ui_serieslist.adapter = SeriesAdapter()
        ui_serieslist.layoutManager = LinearLayoutManager(this)
        _realm = Realm.getDefaultInstance()

    }

    fun onAddButtonTouched(button:View){
        val seriesName  = ui_SerieName.text.toString()
        val serieCategorie = ui_Categorie.text.toString()
        if(seriesName.isNotEmpty() && serieCategorie.isNotEmpty()){
            val series = Series()
            series.name = seriesName
            series.show = serieCategorie
            _realm.beginTransaction()
            _realm.copyToRealm(series)
            _realm.commitTransaction()

            ui_SerieName.text.clear()
            ui_Categorie.text.clear()
            ui_serieslist.adapter = SeriesAdapter()
            ui_serieslist.layoutManager = LinearLayoutManager(this)
        }


    }



}
