package com.example.buygulama.Data

import android.annotation.SuppressLint
import com.example.buygulama.Data.Kelimeler
import com.example.buygulama.Data.VeritabaniYardimcisi

class Kelimelerdao {


    @SuppressLint("Range")
    fun tumKelimeler(vt: VeritabaniYardimcisi): ArrayList<Kelimeler> {
        val kelimelerListe = ArrayList<Kelimeler>()
        val db = vt.writableDatabase

        val c = db.rawQuery("SELECT*FROM kelimeler", null)


        while (c.moveToNext()) {
            val kelime = Kelimeler(
                c.getInt(c.getColumnIndex("kelime_id")),
                c.getString(c.getColumnIndex("kelime_turkce")),
                c.getString(c.getColumnIndex("kelime_anlam"))
            )

            kelimelerListe.add(kelime)
        }
        return kelimelerListe
    }

    @SuppressLint("Range")
    fun aramaYap(vt: VeritabaniYardimcisi, aramaKelime: String): ArrayList<Kelimeler> {
        val kelimelerListe = ArrayList<Kelimeler>()
        val db = vt.writableDatabase

        val c = db.rawQuery("SELECT*FROM kelimeler WHERE kelime_turkce like '%$aramaKelime%'", null)


        while (c.moveToNext()) {
            val kelime = Kelimeler(
                c.getInt(c.getColumnIndex("kelime_id")),
                c.getString(c.getColumnIndex("kelime_turkce")),
                c.getString(c.getColumnIndex("kelime_anlam"))
            )

            kelimelerListe.add(kelime)
        }
        return kelimelerListe
    }
}