package com.nextus.baseapp.ui.home

import android.app.Application
import android.widget.Toast
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.nextus.baseapp.domain.core.Result
import com.nextus.baseapp.domain.model.GistsPublic
import com.nextus.baseapp.ui.base.BaseViewModel
import com.nextus.baseapp.domain.usecase.GetGistsPublicUseCase
import kotlinx.coroutines.launch

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

    val gistsPublicObservableList = ObservableArrayList<GistsPublic>()

    private val _gistsPublicDataList = MutableLiveData<List<GistsPublic>>()
    val gistsPublicDataList: LiveData<List<GistsPublic>> = _gistsPublicDataList

    val isRefreshing: LiveData<Boolean> = gistsPublicDataList.map { false }

    init {
        getGistsPublic()
    }

    fun refresh() {

    }

    fun getGistsPublic() {
        viewModelScope.launch {
            getGistsPublicUseCase().let { result ->
                if(result is Result.Success) {
                    onGistsPublicLoaded(result.data)
                } else {
                    onGistsPublicFailed(result as Result.Error)
                }
            }
        }
    }

    private fun onGistsPublicLoaded(result: List<GistsPublic>) {
        _gistsPublicDataList.value = result
    }

    private fun onGistsPublicFailed(result: Result.Error) {
        Toast.makeText(getApplication(), result.exception.toString(), Toast.LENGTH_SHORT).show()
    }

    fun updateData(gistsPublicList: List<GistsPublic>) {
        gistsPublicObservableList.clear()
        gistsPublicObservableList.addAll(gistsPublicList)
    }
}