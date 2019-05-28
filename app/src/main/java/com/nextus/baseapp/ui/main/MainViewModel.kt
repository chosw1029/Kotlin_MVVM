package com.nextus.baseapp.ui.main

import android.app.Application
import com.nextus.baseapp.data.DataManager
import com.nextus.baseapp.ui.base.BaseViewModel

class MainViewModel(
    application: Application,
    private val dataManager: DataManager
): BaseViewModel<MainNavigator>(application) {

    fun actionClickTest() {
        getNavigator()?.test()
    }
}