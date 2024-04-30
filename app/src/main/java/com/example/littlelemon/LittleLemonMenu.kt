package com.example.littlelemon

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MenuContentPortrait() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = stringResource(id = R.string.appetizers),
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth()
                .background(color = Color(0XFFF2F4FF), shape = RectangleShape)
                .padding(26.dp)
        )
        Text(
            text = stringResource(id = R.string.drinks),
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth()
                .background(color = Color(0XFF96C5F7), shape = RectangleShape)
                .padding(26.dp)
        )
        Text(
            text = stringResource(id = R.string.salad),
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth()
                .background(color = Color(0XFF93ACB5), shape = RectangleShape)
                .padding(26.dp)
        )
        Text(
            text = stringResource(id = R.string.mains),
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth()
                .background(color = Color(0XFF6C756B), shape = RectangleShape)
                .padding(26.dp)
        )
    }
}

@Composable
fun MenuContentLandScape() {
    Column {
        Row(modifier = Modifier.weight(0.5f)) {
            Text(
                text = stringResource(id = R.string.appetizers),
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .weight(0.5F)
                    .fillMaxHeight()
                    .background(color = Color(0XFFF2F4FF), shape = RectangleShape)
                    .padding(26.dp)
            )
            Text(
                text = stringResource(id = R.string.salad),
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.5F)
                    .fillMaxHeight()
                    .background(color = Color(0XFF93ACB5), shape = RectangleShape)
                    .padding(26.dp)
            )
        }
        Row(modifier = Modifier.weight(0.5F)) {
            Text(
                text = stringResource(id = R.string.drinks),
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.5F)
                    .fillMaxHeight()
                    .background(color = Color(0XFF96C5F7), shape = RectangleShape)
                    .padding(26.dp),
            )
            Text(
                text = stringResource(id = R.string.mains),
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.5F)
                    .fillMaxHeight()
                    .background(color = Color(0XFF6C756B), shape = RectangleShape)
                    .padding(26.dp)
            )
        }

    }
}

@Composable
fun MenuContent() {
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        ORIENTATION_LANDSCAPE -> {
            MenuContentLandScape()
        }

        else -> MenuContentPortrait()
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MenuContentPreview() {
    MenuContentLandScape()
}