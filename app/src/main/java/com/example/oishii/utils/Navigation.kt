package com.example.oishii.utils

import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.navigation.NavController
import com.example.oishii.R


enum class Navigation(val path: Int) {
    FIRST_TO_SECOND(R.id.action_FirstFragment_to_SecondFragment),
    INFO_MENU(R.id.infoMenuFragment),
    LOGIN_TO_FIRST(R.id.action_loginFragment_to_FirstFragment),
    FIRST_TO_MENU(R.id.action_FirstFragment_to_menuFragment),
    SECOND_TO_MENU(R.id.action_SecondFragment_to_menuFragment),
    INFO_TO_PROFILE(R.id.action_infoMenuFragment_to_profileFragment)
}

fun navigateUp(navController: NavController,view: View, toolbar: Toolbar?,isUserLoggedIn: Boolean){
    view.setOnClickListener {
        if (toolbar!=null) showHide(toolbar)
        navController.navigateUp()
    }
}

fun navigate(navController: NavController,view: View,Navigation: Int, toolbar: Toolbar?){
    view.setOnClickListener {
        if (toolbar!=null) showHide(toolbar)
        navController.navigate(Navigation)
    }
}


fun showHide(view: View){
    view.isVisible = view.isVisible != true
}