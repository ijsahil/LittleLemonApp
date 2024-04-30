package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawablePanel(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    List(10) {
        Text(text = "item #$it", modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp))
    }
    IconButton(onClick = {
        scope.launch {
            scaffoldState.drawerState.close()
        }
    }) {
        Image(painter = painterResource(id = R.mipmap.exit), contentDescription = "exit")
    }
}
