package dev.adds.freetoplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import dev.adds.freetoplay.model.FreeGamesItem
import dev.adds.freetoplay.ui.theme.FreeToPlayTheme
import dev.adds.freetoplay.viewmodel.LatestGamesViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[LatestGamesViewModel::class.java]

        setContent {
            FreeToPlayTheme {
                LatestGamesApp(viewModel = viewModel)

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(onActionButtonClick: (String) -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        title = { Text(text = "Free Games 😎") },
        actions = {
            IconButton(onClick = { onActionButtonClick("Search click!!") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            /*IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More")
            }*/
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LatestGamesApp(viewModel: LatestGamesViewModel) {
    val snackHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            Toolbar(onActionButtonClick = {
                scope.launch {
                    snackHostState.showSnackbar(it)
                }
            })
        }, content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Row {
                    LatestGames(viewModel)
                }
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackHostState)
        }
    )
}

@Composable
fun LatestGames(viewModel: LatestGamesViewModel) {
    val latestGames by viewModel.latestGamesFlow.collectAsState()
    latestGames?.let {
        LazyColumn(

            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            content = {
                items(it) { item: FreeGamesItem ->
                    CardGameItem(item)
                }
            })
    }
}

@Composable
fun CardGameItem(item: FreeGamesItem) {
    val context = LocalContext.current
    Card(modifier = Modifier
        .padding(horizontal = 8.dp, vertical = 8.dp)
        .clickable { }
        .fillMaxWidth()) {
        Row {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(context)
                    .data(item.thumbnail)
                    .crossfade(true).build(),
                loading = {
                    CircularProgressIndicator()
                },
                contentDescription = item.title,
                modifier = Modifier.fillMaxHeight()
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = item.title, style = typography.titleSmall)
                Text(text = item.shortDescription, style = typography.bodySmall, maxLines = 2)
            }
        }
    }
}


