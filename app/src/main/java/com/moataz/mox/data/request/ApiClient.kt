package com.moataz.mox.data.request

import com.moataz.mox.data.api.*
import com.moataz.mox.utils.helper.HttpRoutes
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    private fun myHttpClient(): OkHttpClient {

        val builder = OkHttpClient()
            .newBuilder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
        return builder.build()
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(HttpRoutes.BASE_URL)
        .client(myHttpClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val apiServiceTop: TopAPIService by lazy {
        retrofit.create(TopAPIService::class.java)
    }

    val apiServiceKotlin: KotlinAPIService by lazy {
        retrofit.create(KotlinAPIService::class.java)
    }

    val apiServicePro: ProAPIService by lazy {
        retrofit.create(ProAPIService::class.java)
    }

    val apiServiceAndroid: AndroidAPIService by lazy {
        retrofit.create(AndroidAPIService::class.java)
    }

    val apiServiceUX: UXAPIService by lazy {
        retrofit.create(UXAPIService::class.java)
    }
}