package com.example.bottomnavigationexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavigationexample.R
import com.example.bottomnavigationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val appBarConfiguration by lazy {
        AppBarConfiguration(setOf(
            R.id.home,
            R.id.favorites,
            R.id.settings,
            R.id.more
        ))
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navController by lazy {
        findNavController(R.id.navHostFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navigationView.setupWithNavController(navController)


        binding.navigationView.getOrCreateBadge(R.id.favorites).apply {
            backgroundColor = ContextCompat.getColor(this@MainActivity, R.color.purple_200)
        }
    }
}