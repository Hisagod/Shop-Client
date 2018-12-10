package com.aib.view.activity

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity<D : ViewDataBinding> : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var injector: DispatchingAndroidInjector<Fragment>

    lateinit var binding: D

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<D>(this, getResId())
        initData(savedInstanceState)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = injector

    abstract fun getResId(): Int

    abstract fun initData(savedInstanceState: Bundle?)
}