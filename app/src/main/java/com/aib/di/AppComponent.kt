package com.aib.di


import com.aib.ShopApplication
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityModule::class
]
)
interface AppComponent {
    fun inject(shopApplication: ShopApplication)
}