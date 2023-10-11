package com.example.borutoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.borutoapp.domain.model.HeroRemoteKey


@Dao
interface HeroRemoteKeyDao {

    @Query("SELECT * FROM hero_remote_key_table WHERE id = :id ")
    suspend fun getRemoteKey(id: Int): HeroRemoteKey?

    @Query("SELECT * FROM hero_remote_key_table")
    suspend fun addAllRemoteKey(heroRemoteKey: List<HeroRemoteKey>)

    @Query("DELETE FROM hero_remote_key_table ")
    suspend fun deleteRemoteKey()
}