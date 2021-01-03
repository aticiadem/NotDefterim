package com.adematici.notdefterim.database

import android.content.ContentValues
import com.adematici.notdefterim.model.NotlarModel

class Notlardao {

    fun notEkle(vt: VeritabaniYardimcisi, not_baslik: String, not_icerik: String){
        val db = vt.writableDatabase
        val values = ContentValues()

        values.put("not_baslik",not_baslik)
        values.put("not_icerik",not_icerik)

        db.insertOrThrow("notlar",null,values)
        db.close()
    }

    fun tumNotlar(vt: VeritabaniYardimcisi) : ArrayList<NotlarModel>{
        val notlarArrayList = ArrayList<NotlarModel>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM notlar",null)

        while (cursor.moveToNext()){
            val not = NotlarModel(cursor.getInt(cursor.getColumnIndex("not_id")),
                cursor.getString(cursor.getColumnIndex("not_baslik")),
                cursor.getString(cursor.getColumnIndex("not_icerik")))
            notlarArrayList.add(not)
        }
        return notlarArrayList
    }

    fun notSil(vt: VeritabaniYardimcisi, not_id: Int){
        val db = vt.writableDatabase
        db.delete("notlar","not_id=?", arrayOf(not_id.toString()))
        db.close()
    }

    fun tekNotGetir(vt: VeritabaniYardimcisi, not_id: Int) : NotlarModel?{
        var gelenNot: NotlarModel? = null
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM notlar WHERE not_id=$not_id",null)

        while (cursor.moveToNext()){
            gelenNot = NotlarModel((cursor.getInt(cursor.getColumnIndex("not_id"))),
                cursor.getString(cursor.getColumnIndex("not_baslik")),
                cursor.getString(cursor.getColumnIndex("not_icerik")))
        }
        return gelenNot
    }

    fun notGuncelle(vt: VeritabaniYardimcisi, not_id: Int, not_baslik: String, not_icerik: String){
        val db = vt.writableDatabase
        val values = ContentValues()

        values.put("not_id",not_id)
        values.put("not_baslik",not_baslik)
        values.put("not_icerik",not_icerik)

        db.update("notlar",values,"not_id=?", arrayOf(not_id.toString()))
        db.close()
    }
}