package com.aib

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.aib.di.DaggerAppComponent
import com.aib.di.Injection
import com.blankj.utilcode.util.Utils
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class ShopApplication @Inject constructor() : Application(), HasActivityInjector {
    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = injector

    override fun onCreate() {
        super.onCreate()

        Utils.init(this)

        DaggerAppComponent.create().inject(this)
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                //注册activity
                if (activity is HasSupportFragmentInjector) {
                    AndroidInjection.inject(activity)
                }

                //注册fragment
                if (activity is Injection) {
                    val appCompatActivity = activity as AppCompatActivity
                    appCompatActivity.supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                            super.onFragmentCreated(fm, f, savedInstanceState)
                            AndroidSupportInjection.inject(f)
                        }
                    }, true)
                }
            }

        })
    }

    companion object {
        // 获取全局上下文
        var context: Context? = null
            private set
    }

}
