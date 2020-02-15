package com.nextus.baseapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nextus.baseapp.data.model.GistsPublic
import com.nextus.baseapp.databinding.ItemGistsBinding
import com.nextus.baseapp.databinding.ItemEmptyBinding
import com.nextus.baseapp.ui.base.BaseRecyclerAdapter

class GistsRecyclerAdapter : BaseRecyclerAdapter<GistsPublic>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<GistsPublic> {
        return if(getItemViewType(viewType) == VIEW_TYPE_NORMAL) {
            val binding = ItemGistsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            GistsPublicViewHolder(
                binding,
                this
            )
        } else {
            val binding = ItemEmptyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            EmptyViewHolder(
                binding,
                this
            )
        }
    }

    class GistsPublicViewHolder(
        private var itemGistsBinding: ItemGistsBinding,
        baseRecyclerAdapter: BaseRecyclerAdapter<GistsPublic>
    ): ViewHolder<GistsPublic>(itemGistsBinding.root, baseRecyclerAdapter) {

        override fun populate(item: GistsPublic, position: Int) {
            itemGistsBinding.data = item
        }

    }

    class EmptyViewHolder(
        itemEmptyBinding: ItemEmptyBinding,
        baseRecyclerAdapter: BaseRecyclerAdapter<GistsPublic>
    ): ViewHolder<GistsPublic>(itemEmptyBinding.root, baseRecyclerAdapter)
}