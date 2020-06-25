package com.nextus.baseapp.ui.main

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.nextus.baseapp.R
import com.nextus.baseapp.databinding.ActivityMainBinding
import com.nextus.baseapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main,
    MainViewModel::class
) {

    override fun onCreate() {
        val host = supportFragmentManager.findFragmentById(R.id.navHostfragment) as NavHostFragment
        NavigationUI.setupWithNavController(bottomNavigation, host.navController)
    }

}
