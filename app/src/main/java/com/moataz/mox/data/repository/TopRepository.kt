package com.moataz.mox.data.repository

import com.moataz.mox.data.api.TopService
import com.moataz.mox.utils.status.Recourses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TopRepository(private val topService: TopService) {
    suspend fun getTopList() = flow {
        emit(Recourses.Loading())
        emit(topService.getArticlesTopList())
    }.flowOn(Dispatchers.IO)
}