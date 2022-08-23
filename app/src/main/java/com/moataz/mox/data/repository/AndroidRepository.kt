package com.moataz.mox.data.repository

import com.moataz.mox.data.api.AndroidAPIService
import com.moataz.mox.data.model.ArticleResponse
import com.moataz.mox.data.request.ApiClient
import io.reactivex.Single

class AndroidRepository {
    private val androidService: AndroidAPIService = ApiClient.apiServiceAndroid

    fun getAndroidList(): Single<ArticleResponse> {
        return androidService.getAndroidList()
    }
}