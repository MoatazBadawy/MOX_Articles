package com.moataz.mox.data.api

import com.moataz.mox.data.model.ArticleResponse
import com.moataz.mox.utils.helper.HttpRoutes
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface KotlinAPIService {
    @GET("v1/api.json")
    fun getKotlinList(
        @Query("rss_url") rssURL: String = HttpRoutes.KOTLIN,
        @Query("api_key") apiKey: String = HttpRoutes.API_KEY
    ): Single<ArticleResponse>
}