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
import com.google.firebase.database.FirebaseDatabase
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var etEmail:EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSingUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


         auth = FirebaseAuth.getInstance()
        etEmail= findViewById(R.id.editTextEmail)
        etPassword= findViewById(R.id.editTextpassword)
        btnSingUp = findViewById(R.id.btn_singup)
        btnSingUp.setOnClickListener {
            val email= etEmail.text.toString().trim()
            val password= etPassword.text.toString().trim()
            if (email.isEmpty() ){
                etEmail.error="Masukkan Email"
                etEmail.requestFocus()
                return@setOnClickListener
            }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    etEmail.error="Email tidak valid"
                    etEmail.requestFocus()
                    return@setOnClickListener
                }


            if (password.isEmpty() || password.length<6){
                etPassword.error="Password harus lebih 6 karakter"
                return@setOnClickListener
            }

            registerUser(email,password)

        }

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser

    }

    private fun registerUser(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Intent(this@RegisterActivity, Home::class.java ).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)

                         }
                    }else{
                        Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }

    }

    fun backLogin(view: View) {
        val login = Intent(this@RegisterActivity,  LoginActivity::class.java)
        startActivity(login)

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }


}