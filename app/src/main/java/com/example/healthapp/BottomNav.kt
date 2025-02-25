package com.example.healthapp

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.google.android.libraries.play.games.inputmapping.Input

@Composable
fun BottomNav(navController: NavController) {
    val items = listOf(
        BottomNavItem("Home", "home", Icons.Filled.Home),
        BottomNavItem("Profile", "profile", Icons.Filled.Person),
    )

    val currentRoute = navController.currentBackStackEntry?.destination?.route

    BottomNavigation(
        backgroundColor = Color(0xAAafd8a3)
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.label,
                        tint = if (currentRoute == item.route) Color(0xAA0e110d) else Color(0xAA232b20) // Mengubah warna ikon
                    )
                },
                label = { Text(item.label) },
                selected = currentRoute == item.route, // Tambahkan logika untuk item yang terpilih
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

data class BottomNavItem(val label: String, val route: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)
