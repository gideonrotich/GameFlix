package com.example.gamesapp.presentation.games.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.gamesapp.R

@Composable

fun TopBar(){
    Row(modifier = Modifier
        .fillMaxWidth())
    {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Top Games",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h4,
            color = Color.White)

            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}
