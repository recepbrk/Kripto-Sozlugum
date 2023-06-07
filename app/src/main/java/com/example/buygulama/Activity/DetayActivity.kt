package com.example.buygulama.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.buygulama.Data.Kelimeler
import com.example.buygulama.R
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)


        val kelime = intent.getSerializableExtra("nesne") as Kelimeler

        textViewİngilizce.text = kelime.kelime_turkce
        textViewTurkce.text = kelime.kelime_anlam
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return super.onCreateOptionsMenu(menu)
    }
}