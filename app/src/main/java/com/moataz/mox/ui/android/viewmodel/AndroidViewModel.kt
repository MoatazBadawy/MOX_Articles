package com.moataz.mox.ui.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moataz.mox.data.model.ArticleResponse
import com.moataz.mox.data.repository.AndroidRepository
import com.moataz.mox.utils.status.Recourses
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AndroidViewModel : ViewModel() {

    private val disposables = CompositeDisposable()
    private val articlesRepository = AndroidRepository()

    private val _mediumObjectsList = MutableLiveData<Recourses<ArticleResponse>>()
    val mediumObjectsList: LiveData<Recourses<ArticleResponse>> get() = _mediumObjectsList

    private fun makeApiCallAndroid() {
        disposables.add(articlesRepository.getAndroidList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result: ArticleResponse ->
                    _mediumObjectsList.postValue(
                        Recourses.Success(
                            result
                        )
                    )
                },
                { error -> _mediumObjectsList.postValue(Recourses.Failure(error.message.toString())) }
            ))
    }

    init {
        makeApiCallAndroid()
    }

    override fun onCleared() {
        disposables.clear()
    }
}