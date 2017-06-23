package com.example.ostanik.workshopapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

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
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
