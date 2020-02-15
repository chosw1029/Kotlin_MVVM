package com.nextus.baseapp.ui.home

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.nextus.baseapp.data.DataManager
import com.nextus.baseapp.data.model.GistsPublic
import com.nextus.baseapp.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author ReStartAllKill
 * @created on 2019-05-28
 * @modified by
 * @updated on
 */

class HomeViewModel(
    application: Application,
    private val dataManager: DataManager
): BaseViewModel<Any>(application) {

    val gistsPublicObservableList = ObservableArrayList<GistsPublic>()
    val gistsPublicMutableLiveData = MutableLiveData<List<GistsPublic>>()

    init {
        test()
    }

    private fun test() {
        mIsLoading.value = true
        addCompositeDisposable(dataManager.getGistsPublic()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                gistsPublicMutableLiveData.value = it
                mIsLoading.value = false
            }, {
                mIsLoading.value = false
            }))
    }

    fun updateData(gistsPublicList: List<GistsPublic>) {
        gistsPublicObservableList.clear()
        gistsPublicObservableList.addAll(gistsPublicList)
    }
}