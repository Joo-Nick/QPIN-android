package com.example.qpin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.qpin.databinding.ActivityMainBinding
import android.view.Gravity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        drawerLayout = findViewById(R.id.drawer_layout)

        // Initialize HomeFragment
        val homeFragment = HomeFragment()
        homeFragment.setDrawerOpenListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Set the initial fragment to HomeFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fv_main, homeFragment)
            .commitAllowingStateLoss()

        setBottomNavigationView()

    }
    private fun setBottomNavigationView() {
        // Set up the navigation item selected listener
        binding.btmNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fv_main, HomeFragment())
                        .commitAllowingStateLoss()
                    true
                }
                R.id.nav_qr -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fv_main, QrmainFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.nav_parking -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fv_main, ParkingFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.nav_frag_find_car -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fv_main, FindCarFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.nav_insurance -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fv_main, InsuranceFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                else -> false
            }
        }
    }
}