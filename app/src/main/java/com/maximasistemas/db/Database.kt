package com.maximasistemas.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context) : SQLiteOpenHelper(context, "bd_maxima", null, 1) {

    private val TABLE_NAME = "Produto"
    private val SQL_SELECT_PRODUTOS = "SELECT * FROM $TABLE_NAME"
    private val SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "descricao TEXT," +
            "fornecedor TEXT)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun createProduto(produto: Produto) {

        val db = this.writableDatabase
        val values = ContentValues()
        values.put("descricao", produto.descricao)
        values.put("fornecedor", produto.fornecedor)
        db.insert(TABLE_NAME, null, values)
        db.close()

    }

    fun readProduto(): List<Produto> {

        val produtoList = ArrayList<Produto>()
        val db = this.readableDatabase
        val cursor = db.rawQuery(SQL_SELECT_PRODUTOS, null)

        if (cursor.moveToFirst()) {
            do {
                val produto = Produto(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                )
                produtoList.add(produto)

            } while (cursor.moveToNext())
        }

        cursor.close()

        return produtoList

    }

    class Produto(val id: Int? = null, val descricao: String?, val fornecedor: String)
}