package com.example.gamesapp.presentation.games_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.gamesapp.R
import com.example.gamesapp.presentation.games_details.GamesDetailViewModel

@Composable
fun Details(navController: NavController,viewModel: GamesDetailViewModel = hiltViewModel()){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Details") },
                backgroundColor = MaterialTheme.colors.background,
                contentColor = colorResource(id = com.example.gamesapp.R.color.text),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp, 24.dp)
                            .clickable {
                                navController.navigateUp()
                            },
                        tint = colorResource(id = R.color.text)
                    )
                }
            )
        },

        content = {
            DetailsView()

        }
    )
}


@Composable
fun DetailsView(viewModel: GamesDetailViewModel = hiltViewModel()){
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        state.games.let { games ->
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white))){

                item {
                    val image: Painter = rememberImagePainter(data = games!!.background_image)
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(346.dp),
                        painter = image,
                        alignment = Alignment.CenterStart,
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    inneddetails(games.name, games.metacritic.toString(), games.name_original)
                }


            }
        }
    }
}