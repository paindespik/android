package com.example.b2c2
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var text = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferenceReader = getSharedPreferences("com.example.test", Context.MODE_PRIVATE)
        text = preferenceReader.getString("SavedText", "").toString()
        Afficher()
    }





    public fun addButtonTouched(button:View) {
        var addText = inputText.text
        text = "$text\n$addText"
        Afficher()

        val preferenceManager = getSharedPreferences("com.example.test", Context.MODE_PRIVATE).edit()
        preferenceManager.putString("SavedText", text)
        preferenceManager.apply()

        inputText.text = null

    }


    public fun Afficher() {
        if (text.length > 0) {
            displayText.text = text
        }
    }
}
