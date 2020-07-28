package com.nextus.baseapp.domain.repository

import com.nextus.baseapp.domain.core.Result
import com.nextus.baseapp.domain.model.GistsPublic
import kotlinx.coroutines.flow.Flow

interface GitRepository {
    fun getGistsPublic(): Flow<Result<List<GistsPublic>>>
}