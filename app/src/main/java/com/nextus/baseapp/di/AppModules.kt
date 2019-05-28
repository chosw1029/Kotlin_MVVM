package com.nextus.baseapp.di

import com.nextus.baseapp.data.DataManager
import com.nextus.baseapp.ui.home.HomeViewModel
import com.nextus.baseapp.ui.main.MainViewModel
import com.nextus.baseapp.ui.mypage.MyPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get())
    }

    viewModel {
        HomeViewModel(get(), get())
    }

    viewModel {
        MyPageViewModel(get(), get())
    }
}

val apiModule = module {
    single {
        DataManager()
    }
}

val appModules = listOf(viewModelModule, apiModule)