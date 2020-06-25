package com.nextus.baseapp.utils

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * @author ReStartAllKill
 * @created on 2019-05-27
 * @modified by
 * @updated on
 */
object BindingUtils {
    @JvmStatic
    @BindingAdapter("isRefreshing")
    fun SwipeRefreshLayout.bindRefreshing(isRefreshing: Boolean) {
        this.isRefreshing = isRefreshing
    }

    @JvmStatic
    @BindingAdapter("onRefresh")
    fun SwipeRefreshLayout.bindRefreshListener(onRefreshListener: SwipeRefreshLayout.OnRefreshListener) =
        setOnRefreshListener(onRefreshListener)
}