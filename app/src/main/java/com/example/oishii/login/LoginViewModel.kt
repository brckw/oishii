package com.example.oishii.login

import androidx.lifecycle.ViewModel
import com.example.oishii.database.AppDatabase
import com.example.oishii.database.User

class LoginViewModel : ViewModel() {

       private val loginRepository: LoginRepository = LoginRepository()



    fun makeNewUser(auth:Boolean,userName: String?, password: String?) {
         if (auth) {
            val newUser = User(
                0,
                userName,
                password,
                auth
            )
            newUser
        } else {
          loginRepository.saveUser(createGuestAccount())
        }
    }

    private fun createGuestAccount():User {
       val guestUser = User(
           0,
           "Guest",
           null,
           false
       )
        return guestUser
    }

}