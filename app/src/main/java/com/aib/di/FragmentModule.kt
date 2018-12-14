package com.aib.di

import com.aib.view.fragment.CommunityFragment
import com.aib.view.fragment.HomeFragment
import com.aib.view.fragment.TypeFragment
import com.aib.view.fragment.UserFragment
import com.atguigu.shoppingmall.shoppingcart.fragment.ShoppingCartFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    /**
     * 首页
     */
    @ContributesAndroidInjector
    abstract fun HomeFragment(): HomeFragment

    /**
     * 个人中心
     */
    @ContributesAndroidInjector
    abstract fun UserFragment(): UserFragment

    /**
     * 购物车
     */
    @ContributesAndroidInjector
    abstract fun ShoppingCartFragment(): ShoppingCartFragment

    /**
     *
     */
    @ContributesAndroidInjector
    abstract fun CommunityFragment(): CommunityFragment

    @ContributesAndroidInjector
    abstract fun TypeFragment():TypeFragment
}