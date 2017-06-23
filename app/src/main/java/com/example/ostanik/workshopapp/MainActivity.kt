package com.example.ostanik.workshopapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainItemListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainAdapter(this)
        recyclerView.adapter = adapter
        adapter.mockedList = listOf("asdfasdf","1234123412341234","aeubviauerbv", "183712985716348957613")
    }

    override fun onItemClicked(content: String) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show()
    }
}
