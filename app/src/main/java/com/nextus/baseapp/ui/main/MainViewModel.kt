package com.nextus.baseapp.ui.main

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.nextus.baseapp.data.DataManager
import com.nextus.baseapp.data.model.GistsPublic
import com.nextus.baseapp.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    application: Application,
    private val dataManager: DataManager
): BaseViewModel<MainNavigator>(application) {

    val gistsPublicObservableList = ObservableArrayList<GistsPublic>()
    val gistsPublicMutableLiveData = MutableLiveData<List<GistsPublic>>()

    init {
        test()
    }

    private fun test() {
        mIsLoading.set(true)
        addCompositeDisposable(dataManager.getGistsPublic()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                gistsPublicMutableLiveData.value = it
                mIsLoading.set(false)
            }, {
                mIsLoading.set(false)
            }))
    }

    fun updateData(gistsPublicList: List<GistsPublic>) {
        gistsPublicObservableList.clear()
        gistsPublicObservableList.addAll(gistsPublicList)
    }

    fun actionClickTest() {
        getNavigator()?.test()
    }
}