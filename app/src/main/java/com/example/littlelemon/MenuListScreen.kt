package com.example.littlelemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.data.DishRepository
import com.example.littlelemon.data.categories


@Composable
fun MenuScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White) // Set background color
    ) {
        // Categories Section
        LazyRow(
            modifier = Modifier.padding(16.dp),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp)
        ) {
            items(categories) {
                CategoryList(it)
            }
        }

        // Menu Items Section
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(DishRepository.menuDishList) {
                MenuDish(dish = it, navController)
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp) // Add vertical spacing between items
                )
            }
        }
    }
}


@Composable
fun CategoryList(text: String = "menu") {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(40),
        colors = ButtonDefaults.buttonColors(Color.LightGray),
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = text, color = Color.Black)
    }
}
