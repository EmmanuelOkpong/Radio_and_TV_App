package com.example.passion945fmabntv.MAIN_SCREEN

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.*
import com.example.passion945fmabntv.R
import com.example.passion945fmabntv.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain3.toolbar)

        binding.appBarMain3.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main3)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_slideshow,R.id.radioFragment,R.id.TVFragment,
                R.id.programScheduleFragment,R.id.advertiseWithUsFragment,R.id.connectWithOAPFragment,
                R.id.sendYourReportsFragment,R.id.aboutUsFragment,R.id.contactUsFragment,R.id.rateUsFragment,
                R.id.feedBackFragment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        //NavigationUI.setupActionBarWithNavController(binding.appBarHomeScreen.bottomnav.navController)
        NavigationUI.setupWithNavController(binding.appBarMain3.bottomview,navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_activity3, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.aboutUsFragment->{
                findNavController(R.id.nav_host_fragment_content_main3).navigate(
                    R.id.aboutUsFragment)}

            R.id.contactUsFragment->{
                findNavController(R.id.nav_host_fragment_content_main3).navigate(
                    R.id.contactUsFragment)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main3)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}