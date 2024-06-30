package com.example.animatednavigator.screens.CatalogScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.animatednavigator.navigation.AppRoutes
import com.example.animatednavigator.navigation.TopNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen() {
    val navController = TopNavController.current
    Scaffold(topBar = { TopAppBar(title = { Text(text = "Каталог") }) }) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Yellow)
        ) {
            Button(onClick = { navController.navigate(AppRoutes.filtersScreenPath) }) {
                Text("Открыть фильтры")
            }
        }
    }
}