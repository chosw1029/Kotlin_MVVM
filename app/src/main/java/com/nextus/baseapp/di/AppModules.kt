package com.nextus.baseapp.di

import com.nextus.baseapp.data.RemoteClient
import com.nextus.baseapp.data.api.GitApi
import com.nextus.baseapp.data.datasource.GitDataSource
import com.nextus.baseapp.data.datasource.GitRemoteDataSource
import com.nextus.baseapp.domain.repository.GitRepository
import com.nextus.baseapp.data.repository.GitRepositoryImpl
import com.nextus.baseapp.ui.home.HomeViewModel
import com.nextus.baseapp.ui.main.MainViewModel
import com.nextus.baseapp.ui.mypage.MyPageViewModel
import com.nextus.baseapp.domain.usecase.GetGistsPublicUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { MyPageViewModel(get()) }
}

val remoteModule = module {
    single { RemoteClient }
}

val dataSourceModule = module {
    single { GitRemoteDataSource(get()) as GitDataSource}
}

val apiModule = module {
    single { gitApi }
}

val repositoryModule = module {
    single { GitRepositoryImpl(get()) as GitRepository }
}

val useCaseModule = module {
    single { GetGistsPublicUseCase(get()) }
}

val retrofit = RemoteClient.createRetrofit(true)
private val gitApi = retrofit.create(GitApi::class.java)

val appModules = listOf(
    remoteModule,
    dataSourceModule,
    viewModelModule,
    apiModule,
    repositoryModule,
    useCaseModule
)