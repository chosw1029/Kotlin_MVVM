package com.nextus.baseapp.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nextus.baseapp.data.model.GistsPublic
import com.nextus.baseapp.ui.home.GistsRecyclerAdapter

/**
 * @author ReStartAllKill
 * @created on 2019-05-27
 * @modified by
 * @updated on
 */
object BindingUtils {

    @JvmStatic
    @BindingAdapter("gistsPublicListAdapter")
    fun setGistsPublicListAdapter(recyclerView: RecyclerView, gistsPublicList: List<GistsPublic>) {
        if(recyclerView.adapter != null) {
            val adapter : GistsRecyclerAdapter = recyclerView.adapter as GistsRecyclerAdapter
            adapter.updateList(gistsPublicList)
        }
    }

}