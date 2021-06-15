package com.example.oishii.views

import android.content.Context
import android.provider.Settings.Global.getString
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.oishii.OishiiApplication
import com.example.oishii.R
import com.example.oishii.menu.Dish
import org.w3c.dom.Text


class DishCard(context: Context, attrs: AttributeSet?): ConstraintLayout(context,attrs) {

private var dish: TextView
private var description: TextView
private var allergies: TextView
var addToCart: TextView
private var price: TextView


    init {
        val view: View = LayoutInflater.from(context).inflate(R.layout.dish_card, this)
        dish = view.findViewById(R.id.dish_textView)
        description = view.findViewById(R.id.description_textView)
        allergies = view.findViewById(R.id.allergies_textView)
        addToCart = view.findViewById(R.id.add_to_cart_textView)
        price = view.findViewById(R.id.price_textView)
    }


    fun createDish(food: Dish){
        dish.text = food.name
        description.text = food.description
        allergies.text = food.allergies
        price.text = setCurreny(food.price)
        check(food.description,food.allergies)
    }

    fun setCurreny(price: Int): String{
        return price.toString() + "kr"
    }

    fun check(descrText: String?, allerText: String?) {
        if (descrText.isNullOrEmpty() || allerText.isNullOrEmpty()) {
            val constraintLayout: ConstraintLayout = findViewById(R.id.dish_layout)
            val constraintSet = ConstraintSet()
            constraintSet.clone(constraintLayout)

            if (descrText.isNullOrEmpty() && allerText.isNullOrEmpty()) {

                constraintSet.connect(
                    R.id.add_to_cart_textView,
                    ConstraintSet.TOP,
                    R.id.dish_textView,
                    ConstraintSet.BOTTOM,
                )
                constraintSet.connect(
                    R.id.price_textView,
                    ConstraintSet.TOP,
                    R.id.dish_textView,
                    ConstraintSet.TOP,
                )
                constraintSet.connect(
                    R.id.price_textView,
                    ConstraintSet.BOTTOM,
                    R.id.add_to_cart_textView,
                    ConstraintSet.BOTTOM,
                )
                constraintSet.applyTo(constraintLayout)

            } else if (allerText.isNullOrEmpty()){
                constraintSet.connect(
                    R.id.add_to_cart_textView,
                    ConstraintSet.TOP,
                    R.id.description_textView,
                    ConstraintSet.BOTTOM,
                )
                constraintSet.applyTo(constraintLayout)
            }
        }
    }

}