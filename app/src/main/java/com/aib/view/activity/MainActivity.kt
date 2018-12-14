package com.aib.view.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.MenuItem

import com.aib.view.fragment.BaseFragment
import com.aib.viewmodel.HomeViewModel
import com.atguigu.shoppingmall.R
import com.aib.view.fragment.CommunityFragment
import com.atguigu.shoppingmall.databinding.ActivityMainBinding
import com.aib.view.fragment.HomeFragment
import com.atguigu.shoppingmall.shoppingcart.fragment.ShoppingCartFragment
import com.aib.view.fragment.TypeFragment
import com.aib.view.fragment.UserFragment

import java.util.ArrayList

import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding>() {
    @Inject
    lateinit var vm: HomeViewModel
    private val fragments = ArrayList<Fragment>()

    override fun getResId(): Int {
        return R.layout.activity_main
    }

    override fun initData(savedInstanceState: Bundle?) {
        fragments.add(HomeFragment())
        fragments.add(TypeFragment())
        fragments.add(CommunityFragment())
        fragments.add(ShoppingCartFragment())
        fragments.add(UserFragment())

        binding.bnv.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.btn_home -> {
                    switchFragment(0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.btn_center -> {
                    switchFragment(4)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

        switchFragment(0)
    }

    fun switchFragment(position: Int) {
        val ft = supportFragmentManager.beginTransaction()
        for (i in fragments.indices) {
            val fragment = fragments[i]
            if (i == position) {
                if (fragment.isAdded) {
                    ft.show(fragment)
                } else {
                    ft.add(R.id.fl, fragment)
                }
            } else {
                if (fragment.isAdded) {
                    ft.hide(fragment)
                }
            }
        }
        ft.commit()
    }
}
