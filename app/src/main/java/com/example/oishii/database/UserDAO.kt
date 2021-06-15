package com.example.oishii.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
@Insert
fun addUser(user: User)
@Query("SELECT * FROM user")
fun getUserInformation(): List<User>
}