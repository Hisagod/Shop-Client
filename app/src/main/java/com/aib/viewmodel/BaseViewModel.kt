package com.aib.viewmodel

import android.arch.lifecycle.ViewModel
import com.aib.net.Api
import javax.inject.Inject

open class BaseViewModel @Inject constructor() : ViewModel() {
    @Inject
    protected lateinit var api: Api
}