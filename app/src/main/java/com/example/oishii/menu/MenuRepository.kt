package com.example.oishii.menu

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.example.oishii.utils.MockApi
import com.google.gson.Gson

class MenuRepository {

    fun fetchUpdatedMenuFromServer(requestQueue: RequestQueue, callback: (MenuList?) -> Unit?){
        val url = "https://www.google.com/"
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { jsonResponse ->
                val updatedMenu = Gson().fromJson(jsonResponse, MenuList::class.java)
                callback(updatedMenu)
            },
            { error ->
                //internet permissions not activated yet
                callback(MockApi.getMockApiMenu())
                //todo change to error codes when API is ready
            }
        )
        requestQueue.add(stringRequest)
    }
}



