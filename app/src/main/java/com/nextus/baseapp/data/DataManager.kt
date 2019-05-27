package com.nextus.baseapp.data

import com.nextus.baseapp.data.model.GistsPublic
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class DataManager {

    private val endPointUser = "http://api.github.com/gists/public"

    fun getGistsPublic(): Single<List<GistsPublic>> {
        return Rx2AndroidNetworking.post(endPointUser)
            .build()
            .getObjectListSingle(GistsPublic::class.java)
    }

}