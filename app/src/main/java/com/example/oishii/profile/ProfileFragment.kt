package com.example.oishii.profile

import android.app.Activity.RESULT_OK
import android.content.*
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.oishii.OishiiApplication
import com.example.oishii.R
import com.example.oishii.database.SHARED_PREF_KEY_PICTURE
import com.example.oishii.database.SHARED_PREF_NAME
import com.example.oishii.utils.Toasts


class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileViewModel
    private lateinit var profilePicture: ImageView
    private lateinit var nameText: TextView
    private var hasCamera: Boolean? = null
    private lateinit var oishiiContext: Context
    val REQUEST_IMAGE_CAPTURE = 1




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profile_fragment, container, false)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        nameText = view.findViewById(R.id.profile_name_textView)
        profilePicture = view.findViewById(R.id.profile_imageView)
        oishiiContext = OishiiApplication.application.applicationContext
        hasCamera =
            oishiiContext.packageManager.hasSystemFeature(
                PackageManager.FEATURE_CAMERA_ANY)

        getUserInfo()

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val picturePath = oishiiContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE)
            .getString(SHARED_PREF_KEY_PICTURE,"")

        if (!picturePath.isNullOrBlank()) {
            viewModel.loadImageFromStorage(picturePath,profilePicture)
        }

        profilePicture.setOnClickListener {
                if (hasCamera == true) {
                    dispatchTakePictureIntent()
                } else {
                    Toasts.cameraError()
                }
        }
    }

    //sends user to phones photo application
    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            Toasts.cameraError()
        }
    }
    //returns photo from phone application
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            profilePicture.setImageBitmap(imageBitmap)
            val path: String? = viewModel.saveToInternalStorage(imageBitmap)
            val prefEdit = oishiiContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE).edit()
            prefEdit.putString(SHARED_PREF_KEY_PICTURE,path)
            prefEdit.apply()
        }
    }

    private fun getUserInfo() {
      val user = viewModel.fetchUserInfo()
        if (user != null) {
            if (user.auth) {
                nameText.text = user.username
            }
        }
    }

}