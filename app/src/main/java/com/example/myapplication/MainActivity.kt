package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btNotificar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btNotificar = findViewById(R.id.btSendNotification)
        btNotificar.setOnClickListener{
            this.showNotification("1234", "Notification", "Descrição")
        }
    }
}