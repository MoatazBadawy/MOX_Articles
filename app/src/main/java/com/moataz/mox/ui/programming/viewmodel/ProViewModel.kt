package com.moataz.mox.ui.programming.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moataz.mox.data.model.ArticleResponse
import com.moataz.mox.data.repository.ProRepository
import com.moataz.mox.utils.status.Recourses
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProViewModel : ViewModel() {

    private val disposables = CompositeDisposable()
    private val articlesRepository = ProRepository()

    private val _mediumObjectsList = MutableLiveData<Recourses<ArticleResponse>>()
    val mediumObjectsList: LiveData<Recourses<ArticleResponse>> get() = _mediumObjectsList

    private fun makeApiCallPro() {
        disposables.add(articlesRepository.getProList()
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
        makeApiCallPro()
    }

    override fun onCleared() {
        disposables.clear()
    }
}