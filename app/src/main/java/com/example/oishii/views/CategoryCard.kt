package com.example.oishii.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.oishii.R
import com.example.oishii.menu.MenuItems

class CategoryCard(context: Context, attrs: AttributeSet?): CardView(context,attrs) {

    private var category: TextView
    var recyclerView: RecyclerView

    init {
        val view: View = LayoutInflater.from(context).inflate(R.layout.menu_catagory_card, this)
        recyclerView = view.findViewById(R.id.rv_child)
        category = view.findViewById(R.id.category_textView)
    }

    fun setDataToUI(categoryDish: MenuItems){
        setCategoryText(categoryDish.category)
    }


    private fun setCategoryText(categoryText: String){
        for (char in categoryText.reversed().uppercase()){
            category.append("$char\n")
        }
    }





}