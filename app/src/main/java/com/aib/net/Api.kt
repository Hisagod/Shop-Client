package com.aib.net

import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("HOME_URL.json")
    fun getHomeJson(): Observable<String>
}