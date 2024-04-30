package com.example.littlelemon

import DishDetail
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNavigation()
        }
    }
}

@Composable
fun MyNavigation() {
    val navController = rememberNavController()



    Scaffold(
        bottomBar = {
            MyBottomNavigation(navController = navController)
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            NavHost(navController = navController, startDestination = HomeTab.route) {
                composable(Location.route) {
                    LocationScreen()
                }
                composable(Home.route) {
                    HomeScreen(navController)
                }
                composable(Menu.route) {
                    MenuScreen(navController)
                }
                composable(Login.route) {
                    LittleLemonLogin(navController = navController)
                }
                composable(
                    DishDetail.route + "/{${DishDetail.argDishId}}",
                    arguments = listOf(navArgument(DishDetail.argDishId) {
                        type = IntType
                    })
                ) { it ->
                    val id =
                        requireNotNull(it.arguments?.getInt(DishDetail.argDishId)) { "Dish id is null" }
                        DishDetail(id)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawablePanel(scaffoldState = scaffoldState, scope = scope)
        },
        topBar = {
            TopAppBar(scaffoldState, scope)
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            UpperPanel()
            LowerPanel(navController)
        }
    }
}

@Composable
fun MyBottomNavigation(navController: NavHostController) {
    val destinationList = listOf(
        MenuList,
        HomeTab,
        Location
    )
    val selectedItem = rememberSaveable {
        mutableIntStateOf(1)
    }

    BottomNavigation(backgroundColor = Color.LightGray) {
        destinationList.forEachIndexed { index, destinationTab ->
            BottomNavigationItem(
                label = { Text(text = destinationTab.title) },
                icon = {
                    Icon(
                        imageVector = destinationTab.icon,
                        contentDescription = destinationTab.title
                    )
                },
                selected = index == selectedItem.intValue,
                onClick = {
                    selectedItem.intValue = index
                    navController.navigate(destinationList[index].route) {
                        popUpTo(HomeTab.route)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
