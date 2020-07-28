package com.nextus.baseapp.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.nextus.baseapp.domain.core.Result
import com.nextus.baseapp.domain.model.GistsPublic
import com.nextus.baseapp.domain.usecase.GetGistsPublicUseCase
import com.nextus.baseapp.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

/**
 * @author ReStartAllKill
 * @created on 2019-05-28
 * @modified by
 * @updated on
 */

class HomeViewModel(
    application: Application,
    private val getGistsPublicUseCase: GetGistsPublicUseCase
): BaseViewModel(application) {

    private val _refreshEvent = MutableLiveData<Unit>()
    val refreshEvent: LiveData<Unit> = _refreshEvent

    private val _gistsPublicDataList = refreshEvent.switchMap {
        getGistsPublicUseCase()
            .flowOn(Dispatchers.IO)
            .map {
                when (it) {
                    is Result.Success -> it.data
                    is Result.Loading -> ArrayList()
                    is Result.Error -> ArrayList()
                }
            }
            .asLiveData()
    }

    var gistsPublicDataList: LiveData<List<GistsPublic>> = _gistsPublicDataList

    val isRefreshing: LiveData<Boolean> = gistsPublicDataList.map { it.isEmpty() }

    init {
        _refreshEvent.value = Unit
    }

    fun getGistsPublic() {
        _refreshEvent.value = Unit
    }
}