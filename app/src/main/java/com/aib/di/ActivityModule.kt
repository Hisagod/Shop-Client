package com.aib.di

import com.atguigu.shoppingmall.app.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [
    FragmentModule::class
])
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun MainActivity(): MainActivity
}