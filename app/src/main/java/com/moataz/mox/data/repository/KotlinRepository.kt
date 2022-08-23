package com.moataz.mox.data.repository

import com.moataz.mox.data.api.KotlinAPIService
import com.moataz.mox.data.model.ArticleResponse
import com.moataz.mox.data.request.ApiClient
import io.reactivex.Single

class KotlinRepository {
    private val kotlinService: KotlinAPIService = ApiClient.apiServiceKotlin

    fun getKotlinList(): Single<ArticleResponse> {
        return kotlinService.getKotlinList()
    }
}