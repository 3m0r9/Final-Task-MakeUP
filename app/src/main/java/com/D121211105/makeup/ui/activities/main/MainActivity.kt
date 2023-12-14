package com.D121211105.makeup.ui.activities.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211105.makeup.data.models.Makeup
import com.D121211105.makeup.ui.theme.MakeupTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        CenterAlignedTopAppBar(
                            modifier = Modifier.background(Color.Blue),
                            title = {
                                Text(
                                    text = "Makeup Products",
                                    fontWeight = FontWeight.SemiBold,
                                )
                            }
                        )
                        val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                        ListMakeupScreen(mainViewModel.mainUiState)
                    }
                }
            }
        }
    }

//    @Composable
//    private fun ListMakeupScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
//        when (mainUiState) {
//            is MainUiState.Loading -> CenterText(text = "Loading...")
//            is MainUiState.Error -> CenterText(text = "Something Error")
//            is MainUiState.Success -> MakeupList(mainUiState.makeup)
//        }
//    }

    @Composable
    private fun ListMakeupScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when (mainUiState) {
            is MainUiState.Loading -> CenterText(text = "Loading...")
            is MainUiState.Error -> CenterText(text = "Something went wrong: ${mainUiState.errorMessage}")
            is MainUiState.Success -> MakeupList(mainUiState.makeup)
        }
    }



    @Composable
    fun CenterText(text: String) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
            )
        }
    }

    @Composable
    fun MakeupList(makeups: List<Makeup>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(makeups) { makeup ->
                MakeupItem(makeup = makeup)
            }
        }

    }

    @Composable
    fun MakeupItem(makeup: Makeup) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .clickable {
                    // Handle item click, e.g., open detail screen
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // Makeup Image
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(makeup.image_link)
                        .crossfade(true)
                        .build(),
                    contentDescription = makeup.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = makeup.name ?: "",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Price: ${makeup.price ?: ""}",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Brand: ${makeup.brand ?: ""}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}