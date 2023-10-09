package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var nextButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            setContentView(R.layout.main_activity)
        } catch (e : Exception) {
            println(e.toString())
        }

        nextButton = findViewById(R.id.next_button)

        nextButton.setOnClickListener {

            val intent = Intent(this, ImagesActivity::class.java)
            startActivity(intent)

        }

    }

}
