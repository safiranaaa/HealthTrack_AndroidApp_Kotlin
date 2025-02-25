package com.example.healthapp.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "health_app.db"
        const val DATABASE_VERSION = 2

        const val TABLE_HEALTH = "health_data"
        const val COLUMN_ID = "id"
        const val COLUMN_NAMA = "nama" // Tambahkan kolom nama
        const val COLUMN_BB = "bb"
        const val COLUMN_TB = "tb"
        const val COLUMN_TENSI = "tensi"
        const val COLUMN_SISTOL = "sistol"
        const val COLUMN_DIASTOL = "diastol"
        const val COLUMN_GLUKOSA = "glukosa"
        const val COLUMN_ASAM_URAT = "asam_urat"
        const val COLUMN_KOLESTEROL = "kolesterol"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = """
            CREATE TABLE $TABLE_HEALTH (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAMA TEXT, 
                $COLUMN_BB TEXT,
                $COLUMN_TB TEXT,
                $COLUMN_TENSI TEXT,
                $COLUMN_SISTOL TEXT,
                $COLUMN_DIASTOL TEXT,
                $COLUMN_GLUKOSA TEXT,
                $COLUMN_ASAM_URAT TEXT,
                $COLUMN_KOLESTEROL TEXT
            )
        """
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_HEALTH")
        onCreate(db)
    }

    // Function to insert data
    fun insertHealthData(nama: String, bb: String, tb: String, tensi: String, sistol: String, diastol: String, glukosa: String, asamUrat: String, kolesterol: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAMA, nama) // Simpan nama
            put(COLUMN_BB, bb)
            put(COLUMN_TB, tb)
            put(COLUMN_TENSI, tensi)
            put(COLUMN_SISTOL, sistol)
            put(COLUMN_DIASTOL, diastol)
            put(COLUMN_GLUKOSA, glukosa)
            put(COLUMN_ASAM_URAT, asamUrat)
            put(COLUMN_KOLESTEROL, kolesterol)
        }
        return db.insert(TABLE_HEALTH, null, values)
    }

    fun getAllHealthData(): List<Map<String, String>> {
        val db = readableDatabase
        val dataList = mutableListOf<Map<String, String>>()
        val cursor = db.rawQuery("SELECT * FROM $TABLE_HEALTH", null)

        cursor.use {
            while (it.moveToNext()) {
                val data = mapOf(
                    COLUMN_ID to it.getInt(it.getColumnIndexOrThrow(COLUMN_ID)).toString(),
                    COLUMN_NAMA to it.getString(it.getColumnIndexOrThrow(COLUMN_NAMA)), // Ambil nama
                    COLUMN_BB to it.getString(it.getColumnIndexOrThrow(COLUMN_BB)),
                    COLUMN_TB to it.getString(it.getColumnIndexOrThrow(COLUMN_TB)),
                    COLUMN_TENSI to it.getString(it.getColumnIndexOrThrow(COLUMN_TENSI)),
                    COLUMN_SISTOL to it.getString(it.getColumnIndexOrThrow(COLUMN_SISTOL)),
                    COLUMN_DIASTOL to it.getString(it.getColumnIndexOrThrow(COLUMN_DIASTOL)),
                    COLUMN_GLUKOSA to it .getString(it.getColumnIndexOrThrow(COLUMN_GLUKOSA)),
                    COLUMN_ASAM_URAT to it.getString(it.getColumnIndexOrThrow(COLUMN_ASAM_URAT)),
                    COLUMN_KOLESTEROL to it.getString(it.getColumnIndexOrThrow(COLUMN_KOLESTEROL))
                )
                dataList.add(data)
            }
        }
        return dataList
    }

    fun deleteHealthDataById(id: Int): Int {
        val db = writableDatabase
        return db.delete(TABLE_HEALTH, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }

    fun updateHealthData(
        id: Int,
        nama: String, // Tambahkan parameter nama
        bb: String,
        tb: String,
        tensi: String,
        sistol: String,
        diastol: String,
        glukosa: String,
        asamUrat: String,
        kolesterol: String
    ): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAMA, nama) // Simpan nama
            put(COLUMN_BB, bb)
            put(COLUMN_TB, tb)
            put(COLUMN_TENSI, tensi)
            put(COLUMN_SISTOL, sistol)
            put(COLUMN_DIASTOL, diastol)
            put(COLUMN_GLUKOSA, glukosa)
            put(COLUMN_ASAM_URAT, asamUrat)
            put(COLUMN_KOLESTEROL, kolesterol)
        }
        return db.update(TABLE_HEALTH, values, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }
}
