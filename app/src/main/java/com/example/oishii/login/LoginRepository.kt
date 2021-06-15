package com.example.oishii.login

import android.app.Application
import com.example.oishii.OishiiApplication
import com.example.oishii.database.AppDatabase
import com.example.oishii.database.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginRepository {

    private val userDAO = AppDatabase.getDatabase(OishiiApplication.application.applicationContext).UserDAO()

    fun saveUser(user: User){
        CoroutineScope(Dispatchers.IO).launch{
            userDAO.addUser(user)
        }
    }
}