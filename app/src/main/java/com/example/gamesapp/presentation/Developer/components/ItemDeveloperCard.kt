package com.example.gamesapp.presentation.Developer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.ImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import com.example.gamesapp.R
import com.example.gamesapp.domain.models.Developer
import com.example.gamesapp.presentation.games.GamesViewModel
import com.example.gamesapp.ui.theme.TextSecondary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ItemDeveloperCard(developer: Developer, viewModel: DeveloperViewModel = hiltViewModel(), onItemClicked: (developer: Developer) -> Unit) {

    Card(
        modifier = Modifier
            .size(150.dp, 270.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = { onItemClicked(developer) }),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            val image: Painter = rememberImagePainter(data = developer.image_background)

            Image(
                modifier = Modifier
                    .height(230.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = image,
                alignment = Alignment.Center,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                text = developer.name!!,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(6.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = Color.White,
                maxLines = 1
            )
        }

    }
}


