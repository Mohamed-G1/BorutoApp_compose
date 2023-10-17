package com.example.borutoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.borutoapp.utils.Constants.HERO_REMOTE_KEY_TABLE_NAME

@Entity(tableName = HERO_REMOTE_KEY_TABLE_NAME)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)
