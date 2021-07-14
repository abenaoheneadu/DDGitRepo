package com.dynamicdevz.ddgitrepo.network

import com.dynamicdevz.ddgitrepo.model.data.GitResponse
import com.dynamicdevz.ddgitrepo.util.Constants.Companion.BASE_URL
import com.dynamicdevz.ddgitrepo.util.Constants.Companion.END_POINT
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class GitRetrofit {
    private val gitService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(GitService::class.java)

    fun getRepo() = gitService.getAllRepositories()
    interface GitService{
        @GET(END_POINT)
        fun getAllRepositories(): Single<GitResponse>
    }
}

