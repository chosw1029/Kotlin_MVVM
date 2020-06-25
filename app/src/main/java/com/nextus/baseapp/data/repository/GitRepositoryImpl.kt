package com.nextus.baseapp.data.repository

import com.nextus.baseapp.data.datasource.GitDataSource
import com.nextus.baseapp.domain.core.Result
import com.nextus.baseapp.domain.model.GistsPublic
import com.nextus.baseapp.domain.repository.GitRepository

class GitRepositoryImpl(private val gitDataSource: GitDataSource): GitRepository {

    override suspend fun getGistsPublic(): Result<List<GistsPublic>> {
        return gitDataSource.getGistsPublic()
    }

}