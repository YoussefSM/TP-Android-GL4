package com.gl4.tp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txtEmail : EditText
    lateinit var txtPassword : EditText
    lateinit var btnLogin : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtEmail = findViewById(R.id.editTextTextEmailAddress)
        txtPassword = findViewById(R.id.editTextTextPassword)

        btnLogin = findViewById(R.id.buttonConnect)
        btnLogin.setOnClickListener { view ->
            val duration = Toast.LENGTH_SHORT

            var email = txtEmail.text.toString()
            var password = txtPassword.text.toString()

            if (email == "gl4@insat.tn" && password == "insat2022") {
                val toast = Toast.makeText(applicationContext, "You are connected !", duration)
                toast.show()

                val intent = Intent(this,WelcomeActivity::class.java)
                intent.putExtra("email",email)
                startActivity(intent)
            }
            else{
                val toast = Toast.makeText(applicationContext, "email $email or password $password are incorrect", duration)
                toast.show()
            }
        }



    }
}