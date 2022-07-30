package com.example.rewardtrackerstub2

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.rewardtrackerstub2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(ContentValues.TAG, "Content View Set")
        Log.d(ContentValues.TAG, R.id.nav_host_fragment.toString())
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        Log.d(ContentValues.TAG, "Nav Host Fragment")
        val navController: NavController = navHostFragment.navController
        Log.d(ContentValues.TAG, "Nav Host Controller")
        setupActionBarWithNavController(navController)
    }
}