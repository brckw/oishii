package com.example.oishii.menu



data class MenuList (
    val id: Int,
    val takeaway: List<MenuItems>,
    val eatAtRestaurant: List<MenuItems>
)
data class MenuItems(
    val category: String,
    var dish: List<Dish>
)
data class Dish(
    val name: String,
    val description: String? = null,
    val allergies: String? = null,
    val price: Int
)


