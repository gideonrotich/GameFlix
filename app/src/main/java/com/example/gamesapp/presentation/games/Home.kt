package com.example.gamesapp.presentation.games

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gamesapp.presentation.Developer.components.DeveloperViewModel
import com.example.gamesapp.presentation.Developer.components.ItemDeveloperCard
import com.example.gamesapp.presentation.Genres.GenresViewModel
import com.example.gamesapp.presentation.Genres.ItemGenresCard
import com.example.gamesapp.presentation.Screen
import com.example.gamesapp.presentation.games.components.ItemGamesCard
import com.example.gamesapp.presentation.games.components.TopBar
import com.example.gamesapp.ui.theme.Purple200
import com.example.gamesapp.ui.theme.Purple500

@Composable
fun Home(
    navController: NavHostController,
    viewModel: GamesViewModel = hiltViewModel(),
    developerViewModel: DeveloperViewModel = hiltViewModel(),
    genresViewModel:GenresViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val developerstate = developerViewModel.state.value
    val genresstate = genresViewModel.state.value


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())) {
            LazyColumn(modifier = Modifier.height(400.dp), reverseLayout = true) {
                items(genresstate.genres.take(1)) { genres ->
                    ItemGenresCard(genre = genres, onItemClicked = {

                    })
                }
            }
            Text(
                text = "Games based on books",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(6.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
            LazyRow(modifier = Modifier.height(170.dp)) {
                items(state.games.takeLast(5)) { games ->
                    ItemGamesCard(game = games, onItemClicked = {
                        navController.navigate(Screen.Details.route + "/${games.id}")
                    })
                }
            }
            Text(
                text = "Award winning games",
                textAlign = TextAlign.Start,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(6.dp),
                color = Color.White
            )
            LazyRow(modifier = Modifier.height(170.dp)) {
                items(state.games) { games ->
                    ItemGamesCard(game = games, onItemClicked = {
                        navController.navigate(Screen.Details.route + "/${games.id}")
                    })
                }
            }
            Text(
                text = "Trending Games",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(6.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
            LazyRow(modifier = Modifier.height(170.dp)) {
                items(state.games) { games ->
                    ItemGamesCard(game = games, onItemClicked = {
                        navController.navigate(Screen.Details.route + "/${games.id}")
                    })
                }
            }
            Text(
                text = "Top 10 games in kenya",
                textAlign = TextAlign.Start,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(6.dp),
                color = Color.White
            )
            LazyRow(modifier = Modifier.height(170.dp)) {
                items(state.games.takeLast(8)) { games ->
                    ItemGamesCard(game = games, onItemClicked = {
                        navController.navigate(Screen.Details.route + "/${games.id}")
                    })
                }
            }
        }


        if (state.isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        if (state.error.isNotBlank()) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(text = state.error.toString(), modifier = Modifier.align(Alignment.Center))
            }
        }
    }

}