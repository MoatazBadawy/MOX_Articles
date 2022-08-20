package com.moataz.mox.data.repository

import com.moataz.mox.data.api.ProService
import com.moataz.mox.utils.status.Recourses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProRepository(private val proService: ProService) {
    suspend fun getTopList() = flow {
        emit(Recourses.Loading())
        emit(proService.getArticlesTopList())
    }.flowOn(Dispatchers.IO)
}