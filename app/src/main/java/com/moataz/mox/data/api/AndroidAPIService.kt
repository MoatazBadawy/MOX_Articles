package com.moataz.mox.data.api

import com.moataz.mox.data.model.ArticleResponse
import com.moataz.mox.utils.helper.HttpRoutes
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AndroidAPIService {
    @GET("v1/api.json")
    fun getAndroidList(
        @Query("rss_url") rssURL: String = HttpRoutes.ANDROID,
        @Query("api_key") apiKey: String = HttpRoutes.API_KEY
    ): Single<ArticleResponse>
}