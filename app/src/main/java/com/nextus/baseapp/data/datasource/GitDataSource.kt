package com.nextus.baseapp.data.datasource

import com.nextus.baseapp.domain.core.Result
import com.nextus.baseapp.domain.model.GistsPublic

interface GitDataSource {
    suspend fun getGistsPublic(): Result<List<GistsPublic>>
}