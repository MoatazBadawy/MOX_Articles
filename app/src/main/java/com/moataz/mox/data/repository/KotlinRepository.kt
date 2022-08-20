package com.moataz.mox.data.repository

import com.moataz.mox.data.api.KotlinService
import com.moataz.mox.utils.status.Recourses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class KotlinRepository(private val kotlinService: KotlinService) {
    suspend fun getTopList() = flow {
        emit(Recourses.Loading())
        emit(kotlinService.getArticlesTopList())
    }.flowOn(Dispatchers.IO)
}