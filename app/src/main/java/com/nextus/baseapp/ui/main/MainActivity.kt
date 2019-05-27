package com.nextus.baseapp.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nextus.baseapp.BR
import com.nextus.baseapp.R
import com.nextus.baseapp.data.model.GistsPublic
import com.nextus.baseapp.databinding.ActivityMainBinding
import com.nextus.baseapp.ui.base.BaseActivity
import com.nextus.baseapp.ui.base.BaseRecyclerAdapter
import com.nextus.baseapp.utils.AppLogger
import com.nextus.baseapp.utils.ViewUtils
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    private val mMainViewModel: MainViewModel by viewModel()
    private lateinit var adapter : GistsRecyclerAdapter

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

        setUp()
        subscribeData()
    }

    private fun setUp() {
        adapter = GistsRecyclerAdapter()
        adapter.setOnItemClickListener { view, gistsPublic, i ->
            Toast.makeText(view.context, "$i) $gistsPublic", Toast.LENGTH_SHORT).show()
        }

        getViewDataBinding().gistsPublicRecycler.adapter = adapter
        getViewDataBinding().gistsPublicRecycler.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun subscribeData() {
        mMainViewModel.gistsPublicMutableLiveData.observe(this, Observer {
            mMainViewModel.updateData(it)
        })
    }

    override fun test() {
        AppLogger.e("Navigator Test")
    }
}
