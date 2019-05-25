package com.nextus.baseapp.ui.main

import android.os.Bundle
import com.nextus.baseapp.BR
import com.nextus.baseapp.R
import com.nextus.baseapp.databinding.ActivityMainBinding
import com.nextus.baseapp.ui.base.BaseActivity
import com.nextus.baseapp.utils.AppLogger
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    private val mMainViewModel: MainViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        mMainViewModel.setNavigator(this)
        return mMainViewModel
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun test() {
        AppLogger.e("Navigator Test")
    }
}
