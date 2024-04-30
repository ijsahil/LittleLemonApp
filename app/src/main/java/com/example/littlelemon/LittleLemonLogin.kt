package com.example.littlelemon

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun LittleLemonLogin(navController: NavHostController) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.mipmap.littlelemon),
            contentDescription = stringResource(
                id = R.string.little_lemon_image_des
            ),
            Modifier
                .size(200.dp)
                .padding(20.dp)
        )
        var userName by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            value = userName,
            onValueChange = { newValue ->
                // Update the value of the text field
                userName = newValue
            },
            label = {
                Text(text = stringResource(id = R.string.user_name))
            },
            modifier = Modifier.padding(6.dp)
        )

        TextField(
            value = password, onValueChange = {
                password = it
            },
            label = {
                Text(text = stringResource(id = R.string.password))
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                if ((userName.text == "Sahil") && (password.text == "kourav")) {
                    navController.navigate(Home.route)
                } else {
                    Toast.makeText(context, "login failed", Toast.LENGTH_SHORT).show()
                }
            },
            border = BorderStroke(1.dp, Color.Red),
            shape = RoundedCornerShape(10.dp),
            colors = buttonColors(Color.Gray),
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = stringResource(id = R.string.login))
        }

    }
}


