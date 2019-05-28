package com.nextus.baseapp.ui.main

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.nextus.baseapp.BR
import com.nextus.baseapp.R
import com.nextus.baseapp.databinding.ActivityMainBinding
import com.nextus.baseapp.ui.base.BaseActivity
import com.nextus.baseapp.utils.AppLogger
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Navigator 는 필요한 경우에만 implement
 * Navigator 는 View 와 ViewModel 을 연결시켜 주는 역할
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    private val mMainViewModel: MainViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        mMainViewModel.setNavigator(this) // Navigator 사용시
        return mMainViewModel
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {
        val host = supportFragmentManager.findFragmentById(R.id.navHostfragment) as NavHostFragment
        NavigationUI.setupWithNavController(bottomNavigation, host.navController)
    }

    override fun test() {
        AppLogger.e("Navigator Test")
    }
}
