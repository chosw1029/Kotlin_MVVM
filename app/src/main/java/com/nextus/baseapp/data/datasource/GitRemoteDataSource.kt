package com.nextus.baseapp.data.datasource

import com.nextus.baseapp.data.api.GitApi
import com.nextus.baseapp.domain.core.Result
import com.nextus.baseapp.domain.model.GistsPublic

class GitRemoteDataSource(private val gitApi: GitApi): GitDataSource {

    override suspend fun getGistsPublic(): Result<List<GistsPublic>> {
        val response = gitApi.getGistsPublic().execute()

        return if(response.isSuccessful) {
            Result.Success(response.body() ?: ArrayList())
        } else {
            Result.Error(Exception("Network Error"))
        }
    }

}