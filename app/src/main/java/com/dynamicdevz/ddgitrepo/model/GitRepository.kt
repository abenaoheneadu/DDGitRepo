package com.dynamicdevz.ddgitrepo.model

import com.dynamicdevz.ddgitrepo.model.data.GitCache
import com.dynamicdevz.ddgitrepo.model.data.GitResponse
import com.dynamicdevz.ddgitrepo.model.db.GitDatabase.Companion.getDao
import com.dynamicdevz.ddgitrepo.network.GitRetrofit
import com.dynamicdevz.ddgitrepo.util.Constants.Companion.CACHE_KEY
import com.google.gson.Gson
import io.reactivex.Single


class GitRepository{
    private val gitRetrofit = GitRetrofit()
    //Reading from online repo
    fun readFromRemoteSource(): Single<GitResponse> = gitRetrofit.getRepo()

    //Reading from cache
    fun readFromCache(): GitResponse {
        val cache = getDao().readFromCache()
        val data = Gson().fromJson(cache.data, GitResponse::class.java)
        return data
    }

    fun saveToCache(response: GitResponse){
        val gson = Gson()
        val json = gson.toJson(response)
        getDao().cacheData(GitCache(
            CACHE_KEY, json))
    }
}