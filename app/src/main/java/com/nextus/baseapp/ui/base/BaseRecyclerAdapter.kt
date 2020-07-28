package com.nextus.baseapp.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseRecyclerAdapter<T>(diffCallBack: DiffUtil.ItemCallback<T>)
    : ListAdapter<T, BaseViewHolder<T>>(diffCallBack) {

    interface ItemClickListener<T> {
        fun onClickItem(view: View, item: T, position: Int)
    }

    private var onItemClickListener : ItemClickListener<T>? = null

    fun setOnItemClickListener(listener: (view: View, T, position: Int) -> Unit) {
        onItemClickListener = object: ItemClickListener<T> {
            override fun onClickItem(view: View, item: T, position: Int) {
                listener(view, item, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClickListener?.onClickItem(holder.itemView, getItem(position), position)
        }
        return holder.bind(getItem(position))
    }
}