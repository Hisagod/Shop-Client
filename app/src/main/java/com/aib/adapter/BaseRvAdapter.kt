package com.aib.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.aib.utils.Extensions

/**
 * 万能适配器
 */
abstract class BaseRvAdapter<D : ViewDataBinding> : RecyclerView.Adapter<BaseRvAdapter<D>.BaseViewHolder>(), Extensions {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder {
        val ctx = p0.context
        val binding: D = p0.createView<D>(getResId(), attachToRoot())
        return BaseViewHolder(binding)
    }

    override fun getItemCount(): Int = getCount()

    override fun onBindViewHolder(p0: BaseViewHolder, p1: Int) {
        bindView(p0.binding)
    }

    inner class BaseViewHolder(binding: D) : RecyclerView.ViewHolder(binding.root) {
        var binding = binding
    }

    abstract fun getResId(): Int

    abstract fun attachToRoot(): Boolean

    abstract fun getCount(): Int

    abstract fun bindView(binding: D)

}