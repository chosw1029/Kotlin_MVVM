package com.nextus.baseapp.data.datasource

import com.nextus.baseapp.data.api.GitApi
import com.nextus.baseapp.domain.core.Result
import com.nextus.baseapp.domain.model.GistsPublic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class GitRemoteDataSource(private val gitApi: GitApi): GitDataSource {

    override suspend fun getGistsPublic(): Result<List<GistsPublic>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = gitApi.getGistsPublic().execute()

                if(response.isSuccessful) {
                    return@withContext Result.Success(response.body() ?: ArrayList())
                } else {
                    return@withContext Result.Error(Exception("Network Error"))
                }

            } catch (exception: Exception) {
                return@withContext Result.Error(exception)
            }
        }
    }

}