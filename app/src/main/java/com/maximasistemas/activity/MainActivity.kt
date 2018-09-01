package com.maximasistemas.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.maximasistemas.R
import com.maximasistemas.db.Database

class MainActivity : AppCompatActivity() {

    //TODO: LIFE CYCLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    //TODO: ON CLICK VIEW

    fun clickScreenOne(view: View) {
        startActivity(Intent(this, Tela1Activity::class.java))
    }

    fun clickScreenTwo(view: View) {
        startActivity(Intent(this, Tela2Activity::class.java))
    }

}
