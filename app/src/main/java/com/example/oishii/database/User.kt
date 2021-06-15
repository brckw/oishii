package com.example.oishii.database

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val username: String?,
    val password: String?,
    @ColumnInfo(name = "user_auth") val auth: Boolean
)
