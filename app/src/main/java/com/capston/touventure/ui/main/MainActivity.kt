package com.capston.touventure.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.capston.touventure.R
import com.capston.touventure.databinding.ActivityMainBinding
import com.capston.touventure.ui.auth.LoginActivity
import com.capston.touventure.ui.fragments.CategoryFragment
import com.capston.touventure.ui.fragments.FavoriteFragment
import com.capston.touventure.ui.fragments.HomeFragment
import com.capston.touventure.ui.fragments.MapsFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = Firebase.auth
        val firebaseUser = firebaseAuth.currentUser

        if (firebaseUser == null) {
            // Not signed in, launch the Login activity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }

        gantiFragment(HomeFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> {
                    gantiFragment(HomeFragment())
                    true
                }
                R.id.navigation_favorite -> {
                    gantiFragment(FavoriteFragment())
                    true
                }
                R.id.navigation_map -> {
                    gantiFragment(MapsFragment())
                    true
                }
                R.id.navigation_category -> {
                    gantiFragment(CategoryFragment())
                    true
                }
                else -> true
            }
        }



    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.main_menu, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.sign_out_menu -> {
//                signOut()
//                true
//            }
////            R.id.navigation_home -> {
////                gantiFragment(HomeFragment())
////                true
////            }
////            R.id.navigation_favorite -> {
////                gantiFragment(FavoriteFragment())
////                true
////            }
////            R.id.navigation_map -> {
////                true
////            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

    private fun gantiFragment(fragment: Fragment) {
        val transaksi = supportFragmentManager.beginTransaction()
        transaksi.replace(R.id.frame, fragment)
        transaksi.commit()
    }

    private fun signOut() {
        firebaseAuth.signOut()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}