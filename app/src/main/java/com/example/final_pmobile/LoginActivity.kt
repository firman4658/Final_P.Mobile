package com.example.final_pmobile

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity(), View.OnClickListener {

     private lateinit var auth: FirebaseAuth

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    private  lateinit var  btnRegister: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        etEmail= findViewById(R.id.emailet)
        etPassword= findViewById(R.id.passwordet)
        btnLogin = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener {
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

            loginUser(email,password)

        }

    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Intent (this@LoginActivity,Home::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }else{
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }

            }
    }

    fun register(view: View) {
        val register = Intent(this@LoginActivity, RegisterActivity::class.java)
        startActivity(register)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
    public override fun onStart() {
        super.onStart()
        if (auth.currentUser != null){
            Intent (this@LoginActivity,Home::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }

}