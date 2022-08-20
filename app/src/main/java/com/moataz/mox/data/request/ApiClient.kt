package com.moataz.mox.data.request

import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request

object ApiClient {
    private val client = OkHttpClient()

    fun makeApiRequest(url: String): Call {
        val request = Request.Builder()
            .url(url)
            .build()
        return client.newCall(request)
    }
}