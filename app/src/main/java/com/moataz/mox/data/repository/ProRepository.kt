package com.moataz.mox.data.repository

import com.moataz.mox.data.api.ProAPIService
import com.moataz.mox.data.model.ArticleResponse
import com.moataz.mox.data.request.ApiClient
import io.reactivex.Single

class ProRepository {
    private val proService: ProAPIService = ApiClient.apiServicePro

    fun getProList(): Single<ArticleResponse> {
        return proService.getProList()
    }
}