package com.aib.di

import com.aib.view.activity.LoginActivity
import com.aib.view.activity.MainActivity
import com.aib.view.activity.RegisterActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [
    FragmentModule::class
])
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun MainActivity(): MainActivity

    /**
     * 注册
     */
    @ContributesAndroidInjector
    abstract fun RegisterActivity(): RegisterActivity

    /**
     * 登录
     */
    @ContributesAndroidInjector
    abstract fun LoginActivity(): LoginActivity
}