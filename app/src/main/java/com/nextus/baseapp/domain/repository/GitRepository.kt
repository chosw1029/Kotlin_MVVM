package com.nextus.baseapp.domain.repository

import com.nextus.baseapp.domain.core.Result
import com.nextus.baseapp.domain.model.GistsPublic

interface GitRepository {
    suspend fun getGistsPublic(): Result<List<GistsPublic>>
}