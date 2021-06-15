package com.example.oishii.profile

import com.example.oishii.OishiiApplication
import com.example.oishii.database.AppDatabase
import com.example.oishii.database.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.security.auth.callback.Callback

class ProfileRepository {

    private val userDAO = AppDatabase.getDatabase(OishiiApplication.application.applicationContext).UserDAO()

    fun fetchUser(callback: (List<User>?) -> Unit?){
        CoroutineScope(Dispatchers.IO).launch{
            callback(userDAO.getUserInformation())
        }
    }
}