package com.example.final_pmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
         auth = FirebaseAuth.getInstance()
        var btn_singup: Button
        btn_singup = findViewById(R.id.btn_singup)
         btn_singup.setOnClickListener {


             val  email: EditText = findViewById(R.id.editTextEmail)
             email.text.toString().trim()

             val  password: EditText = findViewById(R.id.editTextpassword)
             password.text.toString().trim()

             if (email.length()==0){
                 email.error= "Email harus di isi!!!"
                 email.requestFocus()
                 return@setOnClickListener
             }


             if (password.length()==0 || password.length () < 8){
                 password.error="Password harus lebih 8 karakter"
                 password.requestFocus()
                 return@setOnClickListener

             }


             registerUser(email = String(), password= String())
         }

    }

    private fun registerUser(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    val register = Intent(this@RegisterActivity,Home::class.java ).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)

                         }
                    }else{
                        Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }

    }

    fun backLogin(view: View) {
        val login = Intent(this@RegisterActivity,  MainActivity::class.java)
        startActivity(login)

    }

}