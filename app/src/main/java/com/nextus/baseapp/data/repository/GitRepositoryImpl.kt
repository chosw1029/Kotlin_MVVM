package com.nextus.baseapp.data.repository

import com.nextus.baseapp.data.datasource.GitDataSource
import com.nextus.baseapp.domain.core.Result
import com.nextus.baseapp.domain.model.GistsPublic
import com.nextus.baseapp.domain.repository.GitRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GitRepositoryImpl(private val gitDataSource: GitDataSource): GitRepository {
    override fun getGistsPublic() = flow {
        emit(Result.Loading)
        delay(1000)
        emit(gitDataSource.getGistsPublic())
    }
}