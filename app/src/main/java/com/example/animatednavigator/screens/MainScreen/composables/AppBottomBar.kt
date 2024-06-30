package com.example.animatednavigator.screens.MainScreen.composables

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.animatednavigator.navigation.AppRoutes
import com.example.animatednavigator.navigation.MainNavController

@Composable
fun AppBottomBar() {
    NavigationBar() {
        Row(
            horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)

        ) {

            BottomBarItem("Каталог", Icons.Default.ShoppingCart, route = AppRoutes.catalogScreenPath)
            BottomBarItem("Карта", Icons.Default.Home, route = AppRoutes.mapScreenPath)
            BottomBarItem("Настройки", Icons.Default.Settings, route = AppRoutes.settingsScreenPath)
        }
    }
}

@Composable
fun BottomBarItem(label: String, icon: ImageVector, route: String) {
    val mainLevelNavController = MainNavController.current
    val currentBackStackEntry by mainLevelNavController.currentBackStackEntryAsState()
    val currentRoute: String = currentBackStackEntry?.destination?.route ?: AppRoutes.catalogScreenPath
    val isSelected = currentRoute == route
    val color: Color = if (isSelected) Color.Blue else Color.Gray
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    mainLevelNavController.navigate(route) {
                        popUpTo(mainLevelNavController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                    }
                })
            }
            .fillMaxHeight()
    ) {
        Icon(
            icon,
            "",
            modifier = Modifier
                .width(24.dp)
                .height(24.dp),
            tint = color

        )
        Text(label)
    }
}