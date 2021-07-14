package com.dynamicdevz.ddgitrepo.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dynamicdevz.ddgitrepo.model.GitRepository
import com.dynamicdevz.ddgitrepo.model.data.GitResponseItem
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GitViewModel: ViewModel() {
    val gitData = MutableLiveData<List<GitResponseItem>>()
    private val compDisposable = CompositeDisposable()
    private val repository = GitRepository()

    init {
        compDisposable.add(
            repository.readFromRemoteSource()
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .map {

                   repository.saveToCache(it)
                    Log.d("TAG_X", "saving to cache - on ${Thread.currentThread().name}")
                    it

                }
                .subscribe({

                    Log.d("TAG_X", "update LiveData on ${Thread.currentThread().name}")
                    gitData.postValue(it)

                },  {throwable ->
                    Log.d("TAG_X", "Oops: ${throwable.localizedMessage}")
                    gitData.postValue(repository.readFromCache() )
                })

        )
    }

    override fun onCleared() {
        super.onCleared()
        compDisposable.clear()
    }
}