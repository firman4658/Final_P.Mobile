package com.example.final_pmobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


 class MainActivity : AppCompatActivity(), View.OnClickListener {

    private  lateinit var  btnRegister: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun register(view: View) {
        val register = Intent(this@MainActivity, RegisterActivity::class.java)
        startActivity(register)
    }
    fun Login(view: View) {}
     override fun onClick(p0: View?) {
         TODO("Not yet implemented")
     }


 }