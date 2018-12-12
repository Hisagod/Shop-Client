package com.aib.utils

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.ViewGroup

interface Extensions {
    /**
     * ViewGroup创建视图
     */
    fun <T : ViewDataBinding> ViewGroup.createView(resId: Int, attachToRoot: Boolean): T {
        var binding: T? = null
        if (attachToRoot) {
            binding = DataBindingUtil.inflate<T>(LayoutInflater.from(this.context), resId, null, attachToRoot)
        } else {
            binding = DataBindingUtil.inflate<T>(LayoutInflater.from(this.context), resId, this, attachToRoot)
        }
        return binding
    }
}