package com.example.gamesapp.presentation.games

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gamesapp.presentation.Screen
import com.example.gamesapp.presentation.games.components.ItemGamesCard
import com.example.gamesapp.presentation.games.components.TopBar
import com.example.gamesapp.ui.theme.Purple200
import com.example.gamesapp.ui.theme.Purple500

@Composable
fun Home(navController:NavHostController,
         viewModel: GamesViewModel = hiltViewModel()){
    val state = viewModel.state.value


Box(modifier = Modifier
    .fillMaxSize()
    .background(color = Purple500)) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar()
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(modifier = Modifier.height(170.dp)){
            items(state.games){games ->
                ItemGamesCard(game = games, onItemClicked = {
                    navController.navigate(Screen.Details.route + "/${games.id}")
                })
            }
        }
        Text(text = "Award winning games",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(14.dp),
            color = Color.White)
        LazyRow(modifier = Modifier.height(170.dp)){
            items(state.games){games ->
                ItemGamesCard(game = games, onItemClicked = {
                    navController.navigate(Screen.Details.route + "/${games.id}")
                })
            }
        }
        Text(text = "Trending Games",
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(14.dp),
            style = MaterialTheme.typography.body1,
            color = Color.White)
        LazyRow(modifier = Modifier.height(170.dp)){
            items(state.games){games ->
                ItemGamesCard(game = games, onItemClicked = {
                    navController.navigate(Screen.Details.route + "/${games.id}")
                })
            }
        }
        Text(text = "Top 10 games in kenya",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(14.dp),
            color = Color.White)
        LazyRow(modifier = Modifier.height(170.dp)){
            items(state.games){games ->
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