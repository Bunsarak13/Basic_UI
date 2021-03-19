package com.student.basic_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EmptyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val items = arrayOf(AndVersion("Banana"), AndVersion("Lollipop"), AndVersion("Marshmallow"))

        val andVersionRecyclerView = findViewById<RecyclerView>(R.id.andVersionRecyclerView)
        andVersionRecyclerView.layoutManager = LinearLayoutManager(this)
        andVersionRecyclerView.adapter = AndVersionAdapter(items)
    }
}