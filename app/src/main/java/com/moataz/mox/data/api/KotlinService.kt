package com.moataz.mox.data.api

import com.google.gson.Gson
import com.moataz.mox.data.model.ArticleResponse
import com.moataz.mox.data.request.ApiClient.makeApiRequest
import com.moataz.mox.utils.helper.HttpRoutes
import com.moataz.mox.utils.status.Recourses

class KotlinService {
    fun getArticlesTopList(): Recourses<ArticleResponse> {
        val call = makeApiRequest(HttpRoutes.KOTLIN)
        val response = call.execute()
        return if (response.isSuccessful) {
            Gson().fromJson(response.body?.string(), ArticleResponse::class.java).run {
                Recourses.Success(this)
            }
        } else {
            Recourses.Failure(response.message)
        }
    }
}