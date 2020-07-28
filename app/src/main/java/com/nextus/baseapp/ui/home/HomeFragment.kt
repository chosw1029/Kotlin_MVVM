package com.nextus.baseapp.ui.home

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nextus.baseapp.R
import com.nextus.baseapp.databinding.FragmentHomeBinding
import com.nextus.baseapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * @author ReStartAllKill
 * @created on 2019-05-28
 * @modified by
 * @updated on
 */

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home,
    HomeViewModel::class
) {

    private val gistsAdapter = GistsAdapter()

    override fun onCreate() {
        initView()
        initGistsObserve()
    }

    private fun initView() {
        gistsAdapter.apply {
            setOnItemClickListener { view, gistsPublic, i ->
                Toast.makeText(view.context, "$i) $gistsPublic", Toast.LENGTH_SHORT).show()

                val directions = HomeFragmentDirections.actionHomeFragmentToMyPageFragment(gistsPublic.url)
                view.findNavController().navigate(directions)
            }
        }

        gistsPublicRecycler.apply {
            adapter = gistsAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }

    private fun initGistsObserve() {
        viewModel.gistsPublicDataList.observe(this, Observer {
            it.let(gistsAdapter::submitList)
        })
    }

}