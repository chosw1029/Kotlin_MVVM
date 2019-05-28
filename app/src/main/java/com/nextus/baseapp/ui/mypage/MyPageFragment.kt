package com.nextus.baseapp.ui.mypage

import com.nextus.baseapp.BR
import com.nextus.baseapp.R
import com.nextus.baseapp.databinding.FragmentMypageBinding
import com.nextus.baseapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mypage.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author ReStartAllKill
 * @created on 2019-05-28
 * @modified by
 * @updated on
 */

class MyPageFragment : BaseFragment<FragmentMypageBinding, MyPageViewModel>() {

    private val mMyPageViewModel : MyPageViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.fragment_mypage
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): MyPageViewModel {
        return mMyPageViewModel
    }

    override fun setUp() {
        arguments?.let {
            val arguments = MyPageFragmentArgs.fromBundle(it)
            text.text = arguments.testString
        }
    }

}