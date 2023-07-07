package com.example.buygulama.Data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "mycrypto.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE IF NOT EXISTS \"kelimeler\" (\n" +
                    "\t\"kelime_id\"\tINTEGER,\n" +
                    "\t\"kelime_turkce\"\tTEXT,\n" +
                    "\t\"kelime_anlam\"\tTEXT,\n" +
                    "\tPRIMARY KEY(\"kelime_id\" )\n" +
                    ");"
        )

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS kelimeler")
        onCreate(db)
    }
}