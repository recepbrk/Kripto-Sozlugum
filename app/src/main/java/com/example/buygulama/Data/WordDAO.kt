package com.example.buygulama.Data

import android.annotation.SuppressLint

class WordDAO {


    @SuppressLint("Range")
    fun tumKelimeler(vt: DatabaseHelper): ArrayList<WordData> {
        val kelimelerListe = ArrayList<WordData>()
        val db = vt.writableDatabase

        val c = db.rawQuery("SELECT*FROM kelimeler", null)


        while (c.moveToNext()) {
            val kelime = WordData(
                c.getInt(c.getColumnIndex("kelime_id")),
                c.getString(c.getColumnIndex("kelime_turkce")),
                c.getString(c.getColumnIndex("kelime_anlam"))
            )

            kelimelerListe.add(kelime)
        }
        return kelimelerListe
    }

    @SuppressLint("Range")
    fun aramaYap(vt: DatabaseHelper, aramaKelime: String): ArrayList<WordData> {
        val kelimelerListe = ArrayList<WordData>()
        val db = vt.writableDatabase

        val c = db.rawQuery("SELECT*FROM kelimeler WHERE kelime_turkce like '%$aramaKelime%'", null)


        while (c.moveToNext()) {
            val kelime = WordData(
                c.getInt(c.getColumnIndex("kelime_id")),
                c.getString(c.getColumnIndex("kelime_turkce")),
                c.getString(c.getColumnIndex("kelime_anlam"))
            )

            kelimelerListe.add(kelime)
        }
        return kelimelerListe
    }
}