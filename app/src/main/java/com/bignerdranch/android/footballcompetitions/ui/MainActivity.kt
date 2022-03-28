package com.bignerdranch.android.footballcompetitions.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.bignerdranch.android.footballcompetitions.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.main_toolbar)
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        setSupportActionBar(toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNav.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { _, destination, arg ->
            toolbar.title = when (destination.id) {
                R.id.homeFragment -> "Matches"
                R.id.tableFragment -> arg?.getString("name")
                R.id.teamFragment -> "Squad ${arg?.getString("teamName")}"
                R.id.allCompetitionsFragment -> "All Leagues"
                else -> "All Competitions"
            }
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp()
    }


}