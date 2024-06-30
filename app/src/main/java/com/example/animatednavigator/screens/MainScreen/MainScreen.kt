package com.example.animatednavigator.screens.MainScreen

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import com.example.animatednavigator.navigation.MainGraph

import com.example.animatednavigator.navigation.MainNavController
import com.example.animatednavigator.screens.MainScreen.composables.AppBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    CompositionLocalProvider(value = MainNavController provides rememberNavController()) {
        Scaffold(bottomBar = {
            AppBottomBar()
        }) {
            MainGraph()
        }
    }
}