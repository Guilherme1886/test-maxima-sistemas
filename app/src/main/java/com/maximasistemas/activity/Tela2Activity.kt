package com.maximasistemas.activity

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.maximasistemas.R
import kotlinx.android.synthetic.main.activity_tela2.*
import java.util.*

class Tela2Activity : AppCompatActivity() {

    //TODO: LIFE CYCLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        iniciar.setOnClickListener {
            contTextView.visibility = View.GONE
            contTextView.text = "0"

            startService(Intent(this, ContadorService::class.java))
        }

        parar.setOnClickListener {
            stopService(Intent(this, ContadorService::class.java))
            contTextView.visibility = View.VISIBLE
            contTextView.text = ContadorService.cont.toString()
        }
    }

    class ContadorService : Service() {

        companion object {
            var cont = 0
        }

        var timer = Timer()

        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

            cont = 0

            val timerTask = object : TimerTask() {
                override fun run() {
                    cont++
                }
            }

            timer.scheduleAtFixedRate(timerTask, 1000, 20000)

            return super.onStartCommand(intent, flags, startId)
        }

        override fun onBind(p0: Intent?): IBinder? {
            return null
        }

        override fun onDestroy() {
            super.onDestroy()

            timer.cancel()

        }
    }
}
