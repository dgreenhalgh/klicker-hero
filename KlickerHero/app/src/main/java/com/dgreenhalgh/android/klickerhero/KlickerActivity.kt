package com.dgreenhalgh.android.klickerhero

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Button
import android.widget.TextView

class KlickerActivity : AppCompatActivity() {

    private lateinit var kounterTextView : TextView
    private lateinit var klickerButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_klicker)

        kounterTextView = findViewById(R.id.kounter) as TextView
        klickerButton = findViewById(R.id.klicker) as Button

        val kareer = Kareer()

        klickerButton.setOnClickListener { updateKount(kareer) }
    }
    
    private fun updateKount(kareer: Kareer) {
        kareer.kount++
        kounterTextView.apply {
            text = "Count: ${kareer.kount}"
            setBackgroundColor(ContextCompat.getColor(this@KlickerActivity, kareer.tier.kolorResId))
        }
    }
}
