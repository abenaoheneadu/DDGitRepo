package com.dynamicdevz.ddgitrepo.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "git_cache")
data class GitCache(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "cache_id")
    val cacheID: Int,

    @ColumnInfo(name = "data")
    val data: String
)
