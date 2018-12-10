package com.aib.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BaseRvAdapter<D : ViewDataBinding> : RecyclerView.Adapter<BaseRvAdapter.BaseViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder {
        val ctx = p0.context
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: BaseViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    open class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

//    abstract fun getResId(): Int

    fun <T : ViewDataBinding> ViewGroup.createView(resId: Int, attachToRoot: Boolean): ViewDataBinding? {
        var binding: ViewDataBinding? = null
        if (attachToRoot) {
            binding = DataBindingUtil.inflate<T>(LayoutInflater.from(this.context), resId, null, attachToRoot)
        } else {
            binding = DataBindingUtil.inflate<T>(LayoutInflater.from(this.context), resId, this, attachToRoot)
        }
        return binding
    }
}