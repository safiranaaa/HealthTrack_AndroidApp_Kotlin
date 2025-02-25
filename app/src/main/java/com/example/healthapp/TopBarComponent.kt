package com.example.healthapp

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp // Import ikon logout
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeTopBar(onLogout: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text("Home", color = Color(0xAA232b20)) },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "Menu")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(onClick = onLogout) {
                    Icon(Icons.Filled.ExitToApp, contentDescription = "Log Out") // Tambahkan ikon logout
                    Spacer(modifier = Modifier.width(8.dp)) // Tambahkan spasi antara ikon dan teks
                    Text("Log Out")
                }
            }
        },
//        backgroundColor = Color(0xAAafd8a3)
    )
}