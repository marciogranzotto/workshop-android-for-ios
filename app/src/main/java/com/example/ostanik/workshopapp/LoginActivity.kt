package com.example.ostanik.workshopapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import rx.Scheduler
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class LoginActivity : AppCompatActivity() {

    private var subscription: Subscription? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginButton.setOnClickListener {
            onLoginButtonTap()
        }
    }

    private fun onLoginButtonTap() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        performLogin(email, password)
    }

    private fun performLogin(email: String, password: String) {
        subscription = RetrofitHelper.retrofit.create(GreetingsService::class.java)
                .login(UserLogin(email, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                },{
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                })
    }

}
