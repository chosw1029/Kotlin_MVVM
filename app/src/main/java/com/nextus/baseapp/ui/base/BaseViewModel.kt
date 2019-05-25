package com.nextus.baseapp.ui.base

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.nextus.baseapp.data.DataManager
import com.nextus.baseapp.data.model.User
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.android.ext.android.inject
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(application: Application) : AndroidViewModel(application) {

    private var navigator : WeakReference<N>? = null

    private val compositeDisposable = CompositeDisposable()
    val mIsLoading = ObservableField<Boolean>(false)

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun addCompositeDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

    fun getNavigator() : N? {
        return navigator?.get()
    }
}