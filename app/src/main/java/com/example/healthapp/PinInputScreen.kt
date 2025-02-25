package com.example.healthapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PinInputScreen(navController: NavController, isNewMember: Boolean) {
    var pin by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(if (isNewMember) "Buat PIN Baru" else "Masukkan PIN Anda", style = TextStyle(fontSize = 20.sp))
        Spacer(modifier = Modifier.height(14.dp))
        TextField(
            value = pin,
            onValueChange = { pin = it },
            placeholder = { Text("PIN") },
            modifier = Modifier
                .size(width = 300.dp, height = 50.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xAA232b20),
                placeholderColor = Color(0xAA232b20),
                backgroundColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Simpan PIN untuk anggota baru atau verifikasi PIN untuk anggota lama
                if (isNewMember) {
                    // Simpan PIN ke database
                } else {
                    // Validasi PIN dengan database
                }
                navController.navigate("home")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xAAafd8a3),
                contentColor = Color(0xAA232b20)
            )
        ) {
            Text("Lanjutkan")
        }
    }
}
