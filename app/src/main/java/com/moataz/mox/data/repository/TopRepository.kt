package com.moataz.mox.data.repository

import com.moataz.mox.data.api.TopAPIService
import com.moataz.mox.data.model.ArticleResponse
import com.moataz.mox.data.request.ApiClient
import io.reactivex.Single

class TopRepository {
    private val topService: TopAPIService = ApiClient.apiServiceTop

    fun getTopList(): Single<ArticleResponse> {
        return topService.getTopList()
    }
}