package com.nextus.baseapp.data.repository

import com.nextus.baseapp.data.datasource.GitDataSource
import com.nextus.baseapp.domain.repository.GitRepository

class GitRepositoryImpl(private val gitDataSource: GitDataSource): GitRepository {
    override suspend fun getGistsPublic() = gitDataSource.getGistsPublic()
}