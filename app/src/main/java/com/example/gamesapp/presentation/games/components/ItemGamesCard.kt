package com.example.gamesapp.presentation.games.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.gamesapp.R
import com.example.gamesapp.domain.models.Games

@Composable
fun ItemGamesCard(game:Games,onItemClicked: (game:Games) -> Unit){
    Card(modifier = Modifier
        .size(130.dp,170.dp)
        .padding(6.dp)
        .clip(RoundedCornerShape(8.dp))
        .clickable(onClick = { onItemClicked(game) }),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Row(modifier = Modifier
            .fillMaxWidth())
        {
            val image:Painter = rememberImagePainter(data = game.background_image)

            Image(  modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp)),
                painter = image,
                alignment = Alignment.Center,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

        }
    }
}