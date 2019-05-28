package com.nextus.baseapp.ui.home

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nextus.baseapp.BR
import com.nextus.baseapp.R
import com.nextus.baseapp.ui.base.BaseFragment
import com.nextus.baseapp.databinding.FragmentHomeBinding
import com.nextus.baseapp.ui.main.GistsRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author ReStartAllKill
 * @created on 2019-05-28
 * @modified by
 * @updated on
 */

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    private val mHomeViewModel : HomeViewModel by viewModel()
    private val mRecyclerAdapter = GistsRecyclerAdapter()

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): HomeViewModel {
        return mHomeViewModel
    }

    override fun setUp() {
        // RecyclerView 의 각 Item 에 대한 클릭 이벤트 설정
        // Click Event 가 발생한 View, Adapter 에 적용된 Data Model Class, Click Event 가 발생한 Position 을 인자로 사용
        mRecyclerAdapter.setOnItemClickListener { view, gistsPublic, i ->
            Toast.makeText(view.context, "$i) $gistsPublic", Toast.LENGTH_SHORT).show()

            val directions = HomeFragmentDirections.actionHomeFragmentToMyPageFragment().setTestString(gistsPublic.url)
            view.findNavController().navigate(directions)
        }

        gistsPublicRecycler.apply {
            adapter = mRecyclerAdapter
            layoutManager = LinearLayoutManager(this@HomeFragment.context, RecyclerView.VERTICAL, false)
        }

        subscribeData()
    }

    // MutableLiveData 를 이용하여 api 호출 결과가 업데이트 된 경우 이를 RecyclerView 에 적용
    private fun subscribeData() {
        mHomeViewModel.gistsPublicMutableLiveData.observe(this, Observer {
            mHomeViewModel.updateData(it)
        })
    }

}