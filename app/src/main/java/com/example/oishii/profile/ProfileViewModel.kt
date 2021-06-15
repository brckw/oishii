package com.example.oishii.profile

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.example.oishii.OishiiApplication
import com.example.oishii.database.User
import java.io.*

class ProfileViewModel : ViewModel() {

    private var verifedUser: User? = null


    fun saveToInternalStorage(bitmapImage: Bitmap): String? {
        val contextWrapper = ContextWrapper(OishiiApplication.application.applicationContext)
        val directory = contextWrapper.getDir("imageDir", Context.MODE_PRIVATE)
        val imagePath = File(directory, "profile.jpg")
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(imagePath)
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                fos!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return directory.absolutePath
    }

    fun loadImageFromStorage(path: String, profilePicture: ImageView) {
        try {
            val filePath = File(path, "profile.jpg")
            val savedPicture = BitmapFactory.decodeStream(FileInputStream(filePath))
            profilePicture.setImageBitmap(savedPicture)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }

    fun fetchUserInfo(): User? {
        ProfileRepository().fetchUser {
             sortUsers(it)
        }
        return verifedUser
    }

    private fun sortUsers(userList: List<User>?) {
        var verifiedUser: User? = null
        if (userList != null) {
            for (user in userList) {
                if (user.auth)
                    verifiedUser = user
            }
        }
        if (verifiedUser != null) {
            verifedUser = verifiedUser
        }
    }

}