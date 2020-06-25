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
/*

    : RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder<T>>() {

    companion object {
        const val VIEW_TYPE_EMPTY = 0
        const val VIEW_TYPE_NORMAL = 1
    }

    private var onItemClickListener : OnItemClickListener<T>? = null

    interface OnItemClickListener<T> {
        fun onItemClick(view: View, item: T, position: Int)
    }

    fun setOnItemClickListener(listener: (View, T, Int) -> Unit) {
        this.onItemClickListener = object: OnItemClickListener<T> {
            override fun onItemClick(view: View, item: T, position: Int) {
                listener(view, item, position)
            }
        }
    }

    fun getOnItemClickListener() : OnItemClickListener<T>? {
        return onItemClickListener
    }

    private var items = Collections.emptyList<T>()

    override fun getItemCount(): Int {
        return if(items.isEmpty()) 1 else items.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(items.isEmpty()) VIEW_TYPE_EMPTY else VIEW_TYPE_NORMAL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        if(getItemViewType(position) == VIEW_TYPE_NORMAL)
            holder.populate(items[position], position)
    }

    fun updateList(itemList: List<T>) {
        items = itemList
        notifyDataSetChanged()
    }

    fun getItems() : List<T> {
        return items
    }

    open class ViewHolder<T>(
        itemView: View,
        private var baseRecyclerAdapter: BaseRecyclerAdapter<T>
    ): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        open fun populate(item: T, position: Int) {}

        override fun onClick(v: View) {
            if(itemViewType != VIEW_TYPE_EMPTY)
                baseRecyclerAdapter.onItemClickListener?.onItemClick(v, baseRecyclerAdapter.items[adapterPosition], adapterPosition)
        }

    }
}*/
