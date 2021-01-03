package com.adematici.notdefterim.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi (context: Context) : SQLiteOpenHelper(context,"notdefter,",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE notlar(not_id INTEGER PRIMARY KEY AUTOINCREMENT, not_baslik TEXT, not_icerik TEXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS notlar")
        db?.close()
    }

}