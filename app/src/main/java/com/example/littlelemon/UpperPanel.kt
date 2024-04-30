package com.example.littlelemon

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun UpperPanel() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0XFF495E57))
            .padding(vertical = 16.dp, horizontal = 8.dp), // Add padding for better spacing
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally // Center align content horizontally
    ) {
        // Restaurant Name and Location
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center align text horizontally
            modifier = Modifier.padding(vertical = 16.dp) // Add vertical spacing
        ) {
            RestaurantName(
                name = stringResource(id = R.string.title),
                size = 32,
                color = Color(0xFFF4CE14),
                modifier = Modifier.padding(vertical = 8.dp) // Adjust padding
            )
            Text(
                text = stringResource(id = R.string.bhopal),
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp) // Adjust padding
            )
        }

        // Restaurant Description and Image
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween, // Add space between text and image
            verticalAlignment = Alignment.CenterVertically // Center align vertically
        ) {
            Text(
                text = stringResource(id = R.string.restaurant_desc),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f), // Take up available space
                color = Color.White,
                fontSize = 18.sp
            )
            Image(
                painter = painterResource(id = R.mipmap.restaurant),
                contentDescription = "",
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

        // Order Button
        Button(
            onClick = {
                Toast.makeText(context, "Order Confirmed", Toast.LENGTH_LONG).show()
            },
            border = BorderStroke(1.dp, Color.Red),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0XFFF4CE14)),
            modifier = Modifier.padding(vertical = 16.dp) // Add vertical spacing
        ) {
            Text(
                text = stringResource(id = R.string.order),
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun RestaurantName(name: String, size: Int, color: Color, modifier: Modifier) {
    Text(text = name, fontSize = size.sp, color = color, modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun RestaurantNamePreview() {
    RestaurantName(
        name = stringResource(R.string.title),
        size = 32,
        color = Color.Blue,
        modifier = Modifier.padding(22.dp)
    )
}