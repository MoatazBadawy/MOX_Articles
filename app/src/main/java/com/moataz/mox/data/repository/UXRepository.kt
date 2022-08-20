package com.moataz.mox.data.repository

import com.moataz.mox.data.api.UXService
import com.moataz.mox.data.model.ArticleResponse
import com.moataz.mox.utils.status.Recourses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UXRepository(private val uxService: UXService) {
    suspend fun getTopList(): Flow<Recourses<ArticleResponse>> {
        return flow {
            emit(Recourses.Loading())
            emit(uxService.getArticlesTopList())
        }.flowOn(Dispatchers.IO)
    }
}