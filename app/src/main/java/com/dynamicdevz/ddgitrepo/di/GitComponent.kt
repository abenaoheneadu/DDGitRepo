package com.dynamicdevz.ddgitrepo.di

import com.dynamicdevz.ddgitrepo.model.GitRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface GitComponent {
    fun getGitRepository(): GitRepository
}