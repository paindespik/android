package fr.purplegiraffe.projet_liste

import android.app.Application
import io.realm.Realm

class Myapp : Application()
{

    companion object{
        private lateinit var instance:Myapp
        fun getInstance():Myapp{
            return instance
        }
    }
    override fun onCreate()
    {
        super.onCreate()
        Realm.init(this)
        instance = this
    }
}