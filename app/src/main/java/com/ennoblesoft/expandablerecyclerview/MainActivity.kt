package com.ennoblesoft.expandablerecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ennoblesoft.expandablerecyclerview.adapters.NewspaperAdapter
import com.ennoblesoft.expandablerecyclerview.utils.JsonHelper

class MainActivity : AppCompatActivity() {
    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = NewspaperAdapter(this, JsonHelper(this).getNewspaperData())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
