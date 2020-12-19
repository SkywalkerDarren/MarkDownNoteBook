package io.github.skywalkerdarren.markdownnotebook.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import io.github.skywalkerdarren.markdownnotebook.R
import io.github.skywalkerdarren.markdownnotebook.databinding.ActivityMainBinding
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseActivity

class MainActivity : BaseActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        setupDrawerLayout(drawerLayout)
    }

    private fun setupDrawerLayout(drawerLayout: DrawerLayout) {
        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_notebooks, R.id.nav_trash, R.id.nav_settings
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                Log.d(TAG, "slide: $slideOffset")
            }

            override fun onDrawerOpened(drawerView: View) {
                Log.d(TAG, "open")
            }

            override fun onDrawerClosed(drawerView: View) {
                Log.d(TAG, "close")
            }

            override fun onDrawerStateChanged(newState: Int) {
                Log.d(TAG, "newState: $newState")
            }
        })

        binding.itemNotebooks.apply {
            ivIcon.setImageResource(R.drawable.ic_notebook)
            ivTitle.text = getString(R.string.menu_notebooks)
            root.setOnClickListener {
                Log.d(TAG, "itemNotebooks")
                navController.navigate(R.id.nav_notebooks)
                drawerLayout.closeDrawers()
            }
        }

        binding.itemTrash.apply {
            ivIcon.setImageResource(R.drawable.ic_trash)
            ivTitle.text = getString(R.string.menu_trash)
            root.setOnClickListener {
                Log.d(TAG, "itemTrash")
                navController.navigate(R.id.nav_trash)
                drawerLayout.closeDrawers()
            }
        }

        binding.itemSettings.apply {
            ivIcon.setImageResource(R.drawable.ic_setting)
            ivTitle.text = getString(R.string.menu_settings)
            root.setOnClickListener {
                Log.d(TAG, "itemSettings")
                navController.navigate(R.id.nav_settings)
                drawerLayout.closeDrawers()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}