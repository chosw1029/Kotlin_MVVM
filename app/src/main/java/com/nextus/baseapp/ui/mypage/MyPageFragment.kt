package com.nextus.baseapp.ui.mypage

import com.nextus.baseapp.R
import com.nextus.baseapp.databinding.FragmentMypageBinding
import com.nextus.baseapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mypage.*

/**
 * @author ReStartAllKill
 * @created on 2019-05-28
 * @modified by
 * @updated on
 */

class MyPageFragment : BaseFragment<FragmentMypageBinding, MyPageViewModel>(
    R.layout.fragment_mypage,
    MyPageViewModel::class
) {

    override fun onCreate() {
        arguments?.let {
            val arguments = MyPageFragmentArgs.fromBundle(it)
            text.text = arguments.testString
        }
    }

}