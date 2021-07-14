package com.dynamicdevz.ddgitrepo

import android.app.Application
import com.dynamicdevz.ddgitrepo.model.db.GitDatabase

class GitApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        GitDatabase.initializeDatabase(this)
//     GitSingleton.gitComponent =
    }
}