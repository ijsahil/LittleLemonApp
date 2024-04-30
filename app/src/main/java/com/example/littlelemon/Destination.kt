package com.example.littlelemon

interface Destination {
    val route: String
}

object Home : Destination {
    override val route = "Home"
}

object Login : Destination {
    override val route = "Login"
}

object Menu : Destination {
    override val route = "Menu"
}

object DishDetail : Destination{
    override val route = "DishDetail"
    const val argDishId = "DishId"
}