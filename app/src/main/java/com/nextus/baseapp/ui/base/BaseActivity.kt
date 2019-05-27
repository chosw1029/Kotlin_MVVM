package com.nextus.baseapp.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T: ViewDataBinding, V: BaseViewModel<*>> : AppCompatActivity() {

    private lateinit var mViewDataBinding: T

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    abstract fun getBindingVariable(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewDataBinding.setVariable(getBindingVariable(), getViewModel())
        mViewDataBinding.executePendingBindings()
    }

    fun getViewDataBinding() : T {
        return mViewDataBinding
    }
}