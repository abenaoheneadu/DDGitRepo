package com.dynamicdevz.ddgitrepo.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.dynamicdevz.ddgitrepo.model.data.GitCache
import com.dynamicdevz.ddgitrepo.util.Constants.Companion.CACHE_KEY

@Dao
interface GitDAO {
    @Insert(onConflict = REPLACE)
    fun cacheData(data: GitCache)

    @Query("SELECT * FROM git_cache WHERE cache_id = $CACHE_KEY")
    fun readFromCache(): GitCache

}