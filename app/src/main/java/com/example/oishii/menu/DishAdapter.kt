package com.example.oishii.menu

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.example.oishii.OishiiApplication
import com.example.oishii.R
import com.example.oishii.views.DishCard


class DishAdapter(private val dishes : List<Dish>)
: RecyclerView.Adapter<DishAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val dishHolder = DishCard(parent.context,null)
        dishHolder.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return ViewHolder(dishHolder)
    }

    override fun getItemCount(): Int {
        return dishes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = dishes[position]
        holder.dishCard.createDish(dish)
        holder.dishCard.addToCart.setOnClickListener {

            //todo send back data with picked items

            // animation for add to cart text
            val colorFrom: Int = getColor(OishiiApplication.application.applicationContext
                ,R.color.red_Template)
            val colorTo: Int = getColor(OishiiApplication.application.applicationContext
                , R.color.white)
            val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)
            colorAnimation.duration = 1500

            colorAnimation.addUpdateListener { animator -> holder.dishCard.addToCart.setTextColor(animator.animatedValue as Int) }
            colorAnimation.start()
        }
    }


    inner class ViewHolder(val dishCard: DishCard) :
        RecyclerView.ViewHolder(dishCard)
}
