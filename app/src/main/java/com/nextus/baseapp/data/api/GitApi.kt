package com.nextus.baseapp.data.api

import com.nextus.baseapp.domain.model.GistsPublic
import retrofit2.Call
import retrofit2.http.POST

interface GitApi {

    @POST("gists/public")
    fun getGistsPublic(): Call<List<GistsPublic>>

}