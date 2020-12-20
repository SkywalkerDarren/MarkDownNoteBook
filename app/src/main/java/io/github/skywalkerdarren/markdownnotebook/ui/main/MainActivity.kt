package io.github.skywalkerdarren.markdownnotebook.ui.main

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import io.github.skywalkerdarren.markdownnotebook.R
import io.github.skywalkerdarren.markdownnotebook.databinding.ActivityMainBinding
import io.github.skywalkerdarren.markdownnotebook.databinding.AppBarMainBinding
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseActivity
import io.github.skywalkerdarren.markdownnotebook.utils.string

class MainActivity : BaseActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var containerBinding: AppBarMainBinding

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

        binding.container.toolbar.setBackClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.itemNotebooks.apply {
            root.isSelected = true
            root.dispatchSetSelected(true)
            binding.container.toolbar.setTitle(R.string.menu_notebooks.string())

            ivIcon.setImageResource(R.drawable.ic_notebook)
            ivTitle.text = R.string.menu_notebooks.string()
            root.setOnClickListener {
                binding.container.toolbar.setTitle(R.string.menu_notebooks.string())
                selectItem(root)
                Log.d(TAG, "itemNotebooks")
                navController.navigate(R.id.nav_notebooks)
                drawerLayout.closeDrawers()
            }
        }

        binding.itemTrash.apply {
            ivIcon.setImageResource(R.drawable.ic_trash)
            ivTitle.text = getString(R.string.menu_trash)
            root.setOnClickListener {
                binding.container.toolbar.setTitle(R.string.menu_trash.string())
                selectItem(root)
                Log.d(TAG, "itemTrash")
                navController.navigate(R.id.nav_trash)
                drawerLayout.closeDrawers()
            }
        }

        binding.itemSettings.apply {
            ivIcon.setImageResource(R.drawable.ic_setting)
            ivTitle.text = getString(R.string.menu_settings)
            root.setOnClickListener {
                binding.container.toolbar.setTitle(R.string.menu_settings.string())
                selectItem(root)
                Log.d(TAG, "itemSettings")
                navController.navigate(R.id.nav_settings)
                drawerLayout.closeDrawers()
            }
        }


    }

    private fun selectItem(item: ViewGroup) {
        binding.itemNotebooks.root.isSelected = false
        binding.itemTrash.root.isSelected = false
        binding.itemSettings.root.isSelected = false
        binding.itemNotebooks.root.dispatchSetSelected(false)
        binding.itemTrash.root.dispatchSetSelected(false)
        binding.itemSettings.root.dispatchSetSelected(false)
        item.isSelected = true
        item.dispatchSetSelected(true)
    }
}