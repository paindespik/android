package fr.purplegiraffe.liste

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import fr.purplegiraffe.projet_liste.MainActivity
import fr.purplegiraffe.projet_liste.Myapp
import fr.purplegiraffe.projet_liste.R
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cell_series.view.*
import kotlin.coroutines.coroutineContext


class SeriesAdapter : RecyclerView.Adapter <SeriesAdapter.CharactereViewHolder>()
{
    var _SeriesList:RealmResults<Series>
    var _realm:Realm=Realm.getDefaultInstance()
    init
    {
    _SeriesList = _realm.where(Series::class.java).sort("show").findAll()
   if (_SeriesList.size == 0)
   {
       val initialSeriesList = arrayOf(Series("Vikings","histoire"),
           Series("Black sails","histoire"),
           Series("The Musketeers", "histoire"),
           Series("the big bang theory", "sitcom"),
           Series("how i met your mother", "sitcom"),
           Series("brooklyn nine-nine", "sitcom"),
           Series("hawaii 5-0", "Police"),
           Series("Scream", "Horror"))
           _realm.beginTransaction()
           for (Series in initialSeriesList)
           {
               _realm.copyToRealm(Series)
           }
           _realm.commitTransaction()
   }
}

    fun onDeleteTouch(index:Int){
        val serieToRemove = _SeriesList[index]
        if(serieToRemove!= null){
            _realm.beginTransaction()
            serieToRemove.deleteFromRealm()
            _realm.commitTransaction()
        }
    }

    fun  onSerieClick(index:Int){
        val serie = _SeriesList[index]

        if(serie!=null){
            val beuleu = serie.name + " -> " + serie.show
            Toast.makeText(Myapp.getInstance().applicationContext, beuleu, Toast.LENGTH_SHORT).show()
        }


    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactereViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.cell_series,parent, false)
        val holder = CharactereViewHolder(rootView)

        return holder

    }

    override fun getItemCount(): Int {
        return _SeriesList.size
    }

    override fun onBindViewHolder(holder: CharactereViewHolder, position: Int)
    {
        var Series= _SeriesList[position]
        if (Series != null)
        {
            holder.fillWithCharacter(Series)
        }


    }




    inner class CharactereViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView), View.OnClickListener {
        private val ui_title = rootView.ui_title
        private val ui_subtitle = rootView.ui_subtitle

        init {
            rootView.ui_supp.setOnClickListener(this)
            rootView.setOnClickListener(this)
        }


        fun fillWithCharacter(series: Series) {
            ui_title.text = series.name
            ui_subtitle.text = series.show
        }

        override fun onClick(v: View?) {
            if (v != null) {
                if (v.id == R.id.ui_supp) {
                    onDeleteTouch(adapterPosition)
                    notifyDataSetChanged()
                }
                else {
                    onSerieClick(adapterPosition)
                }
            }
        }


    }
}





