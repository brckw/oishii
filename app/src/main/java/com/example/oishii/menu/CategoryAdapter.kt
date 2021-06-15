package com.example.oishii.menu

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oishii.views.CategoryCard

class CategoryAdapter(private val categoryItems: List<MenuItems>):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CategoryCard(parent.context,null)
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categoryItems[position]
        holder.category.setDataToUI(item)

        //setup for child adapter
        val dishLayoutManager = LinearLayoutManager(
            holder.category.recyclerView.context
        )

        dishLayoutManager.initialPrefetchItemCount = 2

        holder.category.recyclerView.apply {
            layoutManager = dishLayoutManager
            adapter = DishAdapter(item.dish)
            setRecycledViewPool(viewPool)
        }
    }


    inner class ViewHolder(val category: CategoryCard) :
        RecyclerView.ViewHolder(category)
}