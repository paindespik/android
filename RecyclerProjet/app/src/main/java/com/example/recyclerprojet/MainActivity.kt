package com.example.recyclerprojet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.RealmClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @RealmClass
    open class Player() : RealmObject() {
        var name:String = ""
        var score:Int = 0
    }
}