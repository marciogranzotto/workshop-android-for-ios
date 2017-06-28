package com.example.ostanik.workshopapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity(), MainItemListener {
    private var subscription: Subscription? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainAdapter(this)
        recyclerView.adapter = adapter

        val greetingsService = RetrofitHelper.retrofit.create(GreetingsService::class.java)
        subscription = greetingsService.fetchGreetings()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    adapter.responseList = response.greetings
                }, { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                })
    }

    override fun onDestroy() {
        subscription?.unsubscribe()
        super.onDestroy()
    }

    override fun onItemClicked(content: String) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show()
    }
}
