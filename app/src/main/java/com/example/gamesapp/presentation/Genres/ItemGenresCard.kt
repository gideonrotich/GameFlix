package com.example.gamesapp.presentation.Genres

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.gamesapp.R
import com.example.gamesapp.domain.models.Developer
import com.example.gamesapp.domain.models.Genres
import com.example.gamesapp.presentation.games.GamesViewModel
import kotlinx.coroutines.launch

@Composable
fun ItemGenresCard(
    genre: Genres,
    viewModel: GenresViewModel = hiltViewModel(),
    onItemClicked: (genre: Genres) -> Unit
) {

    val defaultDominantColor = MaterialTheme.colors.surface
    val dominantColor = remember { mutableStateOf(defaultDominantColor) }
    val dominantTextColor = remember { mutableStateOf(defaultDominantColor) }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(0.dp)
            .background(
                Brush.verticalGradient(
                    listOf(
                        dominantColor.value,
                        MaterialTheme.colors.surface
                    )
                )
            )
            .clickable(onClick = { onItemClicked(genre) }),
        elevation = 0.dp,

        ) {

        val painter =
            rememberImagePainter(data = genre.image_background, builder = { crossfade(true) })

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            dominantColor.value,
                            dominantColor.value.copy(alpha = 0.1F)
                        )
                    )
                ),
            painter = painter,
            alignment = Alignment.Center,
            contentDescription = "",
            contentScale = ContentScale.Crop

        )

        if (painter.state is ImagePainter.State.Success) {
            LaunchedEffect(key1 = painter) {
                launch {
                    val imageDrawable = painter.imageLoader.execute(painter.request).drawable
                    viewModel.getImageDominantSwatch(imageDrawable!!) {
                        dominantColor.value = Color(it.rgb)
                        dominantTextColor.value = Color(it.titleTextColor)
                    }
                }
            }
        }

        Column(modifier = Modifier.height(150.dp), verticalArrangement = Arrangement.Top) {
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Red, fontSize = 40.sp)) {
                                append(" G")
                            }
                            append("ame")
                            withStyle(style = SpanStyle(color = Color.Red, fontSize = 40.sp)) {
                                append("F")
                            }
                            append("lix")
                        },
                        textAlign = TextAlign.Start,
                        fontStyle = FontStyle.Normal,
                        fontSize = 28.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(0.dp),
                        color = Color.White,
                    )


                }
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_search_24),
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.CenterVertically),
                        contentDescription = "drawable icons",
                        tint = Color.White,
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Card(
                        modifier = Modifier
                            .size(30.dp, 30.dp)
                            .align(Alignment.CenterVertically)
                            .clip(
                                RoundedCornerShape(4.dp)
                            )
                    ) {
                        val images: Painter = rememberImagePainter(R.color.purple_200)

                        Image(
                            modifier = Modifier
                                .fillMaxWidth(),
                            painter = images,
                            alignment = Alignment.Center,
                            contentDescription = "",
                            contentScale = ContentScale.Crop

                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))

                }
            }
        }




        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        )
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = genre.slug,
                    textAlign = TextAlign.Start,
                    fontStyle = FontStyle.Normal,
                    fontSize = 46.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(2.dp),
                    color = Color.White,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                dominantColor.value,
                                Color.Transparent,
                                Color.Transparent,
                                dominantColor.value.copy(alpha = 0.1F, 0F, 0F, 0F)
                            )
                        )
                    )
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_add_24),
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterHorizontally),
                        contentDescription = "drawable icons",
                        tint = Color.White,
                    )
                    Text(
                        text = "My List", color = Color.White, fontSize = 14.sp,
                    )
                }
                Spacer(modifier = Modifier.width(40.dp))

                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier.width(120.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_play_arrow_24),
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.CenterVertically),
                            contentDescription = "drawable icons",
                            tint = Color.Unspecified,
                        )
                        Text(text = "Play", modifier = Modifier.align(Alignment.CenterVertically))
                    }

                }
                Spacer(modifier = Modifier.width(40.dp))
                Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_info_24),
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterHorizontally),
                        contentDescription = "drawable icons",
                        tint = Color.White,
                    )
                    Text(
                        text = "Info", color = Color.White, fontSize = 14.sp,
                    )
                }

            }
        }
    }


}