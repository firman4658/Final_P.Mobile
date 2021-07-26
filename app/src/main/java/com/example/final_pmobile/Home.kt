package com.example.final_pmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class Home : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var btnlogout: Button
    private lateinit var nav_bottom: BottomNavigationView
    private lateinit var toolbar: Toolbar
    private val Home = HomeFragment()
    private val Profile = ProfileFragment()
    private val Lokasi = LokasiFragment()
    private val Kampus = KampusFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replaceFragment(Home)
        val  bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.item_home -> replaceFragment(Home)
                R.id.item_profile -> replaceFragment(Profile)
                R.id.item_lokasi -> replaceFragment(Lokasi)
                R.id.item_kampus -> replaceFragment(Kampus)
            }
            true

        }
    }
    private fun replaceFragment(fragment:Fragment ){
        if(fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                auth.signOut()
                Intent(this@Home, LoginActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
                return true
            }
            else -> return true
        }

    }

}


