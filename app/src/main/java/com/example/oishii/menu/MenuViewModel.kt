package com.example.oishii.menu

import android.opengl.Visibility
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import com.android.volley.toolbox.Volley
import com.example.oishii.OishiiApplication
import com.example.oishii.utils.Toasts
import com.example.oishii.utils.showHide


class MenuViewModel : ViewModel() {

    private val menuRepository = MenuRepository()
    private val requestQueue =
        Volley.newRequestQueue(OishiiApplication.application.applicationContext)


    fun fetchMenuFromApi(progressBar: ProgressBar,isTakeAway: Boolean?, callback: (List<MenuItems>) -> Unit){
        menuRepository.fetchUpdatedMenuFromServer(
            requestQueue,
        ) { updatedMenu ->
            if (updatedMenu != null){
                callback(sortMenu(updatedMenu,isTakeAway))
            } else {
                //todo change when api ready
                Toasts.apiErrorCodes(errorCode = 404)
                showHide(progressBar)
            }
        }
    }

    private fun sortMenu(menu: MenuList, isTakeAway: Boolean?): List<MenuItems>{
        return if (isTakeAway != true){
            menu.takeaway
        } else {
            menu.eatAtRestaurant
        }
    }


}