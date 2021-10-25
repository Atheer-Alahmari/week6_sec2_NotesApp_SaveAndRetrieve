package com.example.week6_sec2_notesappsaveandretrieve

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper (context: Context): SQLiteOpenHelper(context,"details.db", null ,1) {

    var sqliteDatabase: SQLiteDatabase =writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table massage (Note text )")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun save_date(input: String): Long {
        var cv= ContentValues()
        cv.put("Note",input)

        var status=sqliteDatabase.insert("massage",null,cv)
        return status
    }

    fun retrive(): ArrayList<String> {
        var c: Cursor =sqliteDatabase.query("massage",null,null, null,null,null,null)

        c.moveToFirst()

        var listNote= arrayListOf<String>()

        while (!c.isAfterLast) {

             var note =  c.getString(c.getColumnIndex("Note"))
            listNote.add(note)

            c.moveToNext()
        }
        return listNote

    }


}