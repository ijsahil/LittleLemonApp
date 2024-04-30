package com.example.littlelemon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

interface DestinationTab {
    val route: String
    val title: String
    val icon: ImageVector
}

object HomeTab : DestinationTab {
    override val route = "Home"
    override val title = "Home"
    override val icon = Icons.Filled.Home
}

object MenuList : DestinationTab {
    override val route: String = "Menu"
    override val title: String = "Menu"
    override val icon = Icons.Filled.Menu
}

object Location : DestinationTab {
    override val route: String = "Location"
    override val title: String = "Location"
    override val icon: ImageVector = Icons.Filled.LocationOn
}