package com.example.littlelemon.data

import com.example.littlelemon.R

data class MenuDish(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val image: Int,
)

object DishRepository {
    val menuDishList = listOf(
        MenuDish(
            id = 1,
            name = "Butter Chicken",
            description = "Tender chicken cooked in a creamy tomato-based sauce.",
            price = 300, // Assuming the price is in Indian Rupees
            image = R.mipmap.butterchicken // Assuming R.drawable.butter_chicken is the resource ID of the image
        ),

        MenuDish(
            id = 2,
            name = "Palak Paneer",
            description = "Paneer cooked in a creamy spinach gravy with aromatic spices.",
            price = 250,
            image = R.mipmap.palakpanner
        ),

        MenuDish(
            id = 3,
            name = "Masoor Dal",
            description = "Red lentils cooked with onions, tomatoes, garlic, and spices.",
            price = 150,
            image = R.mipmap.masoordal
        ),
        MenuDish(
            id = 4,
            name = "Govi Paratha",
            description = "Potatoes and cauliflower cooked with onions, tomatoes, and spices.",
            price = 200,
            image = R.mipmap.goviparatha
        ),
        MenuDish(
            id = 5,
            name = "Chicken Biryani",
            description = "Fragrant rice dish cooked with marinated chicken pieces and spices.",
            price = 350,
            image = R.mipmap.chickenbriyani
        ),

        MenuDish(
            id = 6,
            name = "Chole Bhature",
            description = "Spicy chickpea curry served with deep-fried bread.",
            price = 180,
            image = R.mipmap.cholabhatuta
        ),

        MenuDish(
            id = 7,
            name = "Rogan Josh",
            description = "Tender meat cooked in a rich, aromatic gravy flavored with spices.",
            price = 400,
            image = R.mipmap.rogangosh
        ),

        MenuDish(
            id = 8,
            name = "Paneer Tikka",
            description = "Marinated paneer skewered and grilled until charred and smoky.",
            price = 220,
            image = R.mipmap.pannerdosa
        ),

        MenuDish(
            id = 9,
            name = "Dosa",
            description = "Thin, crispy pancake made from fermented rice and lentil batter.",
            price = 120,
            image = R.mipmap.dosa
        ),

        MenuDish(
            id = 10,
            name = "Rasgulla",
            description = "Soft and spongy cottage cheese balls cooked in sugar syrup.",
            price = 50,
            image = R.mipmap.gulabjamun
        )
    )

    fun getDish(id: Int) = menuDishList.firstOrNull {
        it.id == id
    }
}
