package com.aib.view.fragment

import android.os.Bundle
import android.view.View

import com.atguigu.shoppingmall.R
import com.aib.view.activity.LoginActivity
import com.atguigu.shoppingmall.databinding.FragmentUserBinding
import com.aib.view.activity.MsgActivity
import com.blankj.utilcode.util.ActivityUtils

class UserFragment : BaseFragment<FragmentUserBinding>() {
    override fun getResId(): Int {
        return R.layout.fragment_user
    }

    override fun initData(savedInstanceState: Bundle?) {
        binding.contr = this
    }

    fun enterLogin(view: View) {
        ActivityUtils.startActivity(LoginActivity::class.java)
    }

    fun enterMsg(view: View) {
        ActivityUtils.startActivity(MsgActivity::class.java)
    }
}
