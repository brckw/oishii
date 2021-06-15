package com.example.oishii.utils

import com.example.oishii.menu.Dish
//import com.example.oishii.menu.EatAtRestaurant
import com.example.oishii.menu.MenuList
import com.example.oishii.menu.MenuItems

object MockApi {



   private val menu = MenuList(
            1,
        listOf(
            MenuItems("ramen", listOf(
                Dish("vegan ramen",
            "Fresh ramen noodles, tofu, scallions, shitake mushrooms, leeks, bamboo shoots, pak choi in spicy dobanjian soup.",
            "hvete, soya, sesam, nøtter", 70),
                Dish("spicy vegan ramen",
                "Fresh ramen noodles, tofu, scallions, shitake mushrooms, leeks, bamboo shoots, pak choi in spicy dobanjian soup",
            "hvete, soya, sesam nøtter",70)
            )
        ),
            MenuItems("wok", listOf(
                Dish("vegan pad thai prik",
            "Rice noodle stick with tofu, bean sprouts and Chines chives in chilli sauce. Topped with cashew and lime.",
            "nøtter, soya",70),
                Dish("vegan teriyaki noodles","wheat noodles woked with tofu, pak choi, bell peppers, red onions and broccoli in teriyaki.",
               "hvete soya",70)
            )
            ),
            MenuItems("drinks", listOf(
                Dish("sakura ramune",null,null,30),
                Dish("coffe",null,null,20),
                Dish("soda", "Coca-cola \n Coca-cola zero \n sparkling water", null,35)
            )
        )
            )
       ,

        listOf(MenuItems("wok", listOf(
            Dish("vegan pad thai prik",
                "Rice noodle stick with tofu, bean sprouts and Chines chives in chilli sauce. Topped with cashew and lime.",
                "nøtter, soya",70),
            Dish("vegan teriyaki noodles","wheat noodles woked with tofu, pak choi, bell peppers, red onions and broccoli in teriyaki.",
                "hvete soya",70)
        )
        )
            ,
            MenuItems("ramen", listOf(
                Dish("vegan ramen",
                    "Fresh ramen noodles, tofu, scallions, shitake mushrooms, leeks, bamboo shoots, pak choi in spicy dobanjian soup.",
                    "hvete, soya, sesam, nøtter", 70),
                Dish("spicy vegan ramen",
                    "Fresh ramen noodles, tofu, scallions, shitake mushrooms, leeks, bamboo shoots, pak choi in spicy dobanjian soup",
                    "hvete, soya, sesam nøtter",70)
            )
            ) ,
            MenuItems("drinks", listOf(
                Dish("sakura ramune",null,null,30),
                Dish("coffe",null,null,20),
                Dish("soda", "Coca-cola\nCoca-cola zero\nsparkling water", null,35)
            )
            )
        )
    )


        fun getMockApiMenu(): MenuList {
            return menu
        }

    }



