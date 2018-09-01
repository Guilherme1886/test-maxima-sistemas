package com.maximasistemas

import android.app.Application
import android.util.Log
import com.maximasistemas.db.Database

class App : Application() {

    companion object {
        var database: Database? = null
    }

    override fun onCreate() {
        super.onCreate()

        database = Database(this)

        for (i in 1..20) {
            database?.createProduto(Database.Produto(null, "Descricao $i", "Fornecedor $i"))
        }

    }
}