package com.moataz.mox.data.repository

import com.moataz.mox.data.api.UXAPIService
import com.moataz.mox.data.model.ArticleResponse
import com.moataz.mox.data.request.ApiClient
import io.reactivex.Single

class UXRepository {
    private val uxService: UXAPIService = ApiClient.apiServiceUX

    fun getUXList(): Single<ArticleResponse> {
        return uxService.getUXList()
    }
}