package com.nextus.baseapp.ui.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class BaseRecyclerAdapter<T> : RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder<T>>() {

    companion object {
        const val VIEW_TYPE_EMPTY = 0
        const val VIEW_TYPE_NORMAL = 1
    }

    private var onItemClickListener : OnItemClickListener<T>? = null

    interface OnItemClickListener<T> {
        fun onItemClick(view: View, position: Int, type: Int)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<T>) {
        this.onItemClickListener = onItemClickListener
    }

    fun getOnItemClickListener() : OnItemClickListener<T>? {
        return onItemClickListener
    }

    private var items = Collections.emptyList<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return if(items.isEmpty()) 1 else items.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(items.isEmpty()) VIEW_TYPE_EMPTY else VIEW_TYPE_NORMAL
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        if(getItemViewType(position) == VIEW_TYPE_NORMAL)
            holder.populate(items[position], position)
    }

    fun updateList(itemList: List<T>) {
        items = itemList
    }

    fun getItems() : List<T> {
        return items
    }

    class ViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun populate(item: T, position: Int) {

        }

        override fun onClick(v: View?) {

        }
    }
}