package com.nextus.baseapp.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nextus.baseapp.BR
import com.nextus.baseapp.R
import com.nextus.baseapp.databinding.ActivityMainBinding
import com.nextus.baseapp.ui.base.BaseActivity
import com.nextus.baseapp.utils.AppLogger
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Navigator 는 필요한 경우에만 implement
 * Navigator 는 View 와 ViewModel 을 연결시켜 주는 역할
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    private val mMainViewModel: MainViewModel by viewModel()
    private val adapter = GistsRecyclerAdapter()

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeData()
    }

    // 일반적인 설정 작업 코드를 작성
    override fun setUp() {
        // RecyclerView 의 각 Item 에 대한 클릭 이벤트 설정
        // Click Event 가 발생한 View, Adapter 에 적용된 Data Model Class, Click Event 가 발생한 Position 을 인자로 사용
        adapter.setOnItemClickListener { view, gistsPublic, i ->
            Toast.makeText(view.context, "$i) $gistsPublic", Toast.LENGTH_SHORT).show()
        }

        getViewDataBinding().gistsPublicRecycler.adapter = adapter
        getViewDataBinding().gistsPublicRecycler.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    // MutableLiveData 를 이용하여 api 호출 결과가 업데이트 된 경우 이를 RecyclerView 에 적용
    private fun subscribeData() {
        mMainViewModel.gistsPublicMutableLiveData.observe(this, Observer {
            mMainViewModel.updateData(it)
        })
    }

    override fun test() {
        AppLogger.e("Navigator Test")
    }
}
