package com.example.healthapp

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.healthapp.data.DatabaseHelper
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_ASAM_URAT
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_BB
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_DIASTOL
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_GLUKOSA
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_ID
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_KOLESTEROL
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_SISTOL
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_TB
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_TENSI

@Composable
fun HealthInputScreen(navController: NavController) {
    val context = LocalContext.current
    val databaseHelper = DatabaseHelper(context)

    // State untuk input data
    var nama by remember { mutableStateOf("") }
    var bb by remember { mutableStateOf("") }
    var tb by remember { mutableStateOf("") }
    var tensi by remember { mutableStateOf("") }
    var sistol by remember { mutableStateOf("") }
    var diastol by remember { mutableStateOf("") }
    var glukosa by remember { mutableStateOf("") }
    var asamUrat by remember { mutableStateOf("") }
    var kolesterol by remember { mutableStateOf("") }

    // Membuat ScrollState
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Input Data Kesehatan", color = Color(0xAA232b20)) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) { // Navigasi kembali ke Home
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color(0xAA232b20))
                    }
                },
                actions = {
                    IconButton(onClick = {
                        // Logika untuk logout
                        Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                        // Tambahkan logika untuk mengarahkan ke layar login
                    }) {
                        Icon(Icons.Default.ExitToApp, contentDescription = "Logout", tint = Color(0xAA232b20))
                    }
                },
                backgroundColor = Color(0xAAafd8a3)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(scrollState), // Menambahkan guliran vertikal
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            TextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xAA232b20),
                    placeholderColor = Color(0xAA232b20),
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = bb,
                onValueChange = { bb = it },
                label = { Text("Berat Badan (BB)") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xAA232b20),
                    placeholderColor = Color(0xAA232b20),
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = tb,
                onValueChange = { tb = it },
                label = { Text("Tinggi Badan (TB)") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xAA232b20),
                    placeholderColor = Color(0xAA232b20),
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = tensi,
                onValueChange = { tensi = it },
                label = { Text("Tensi") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xAA232b20),
                    placeholderColor = Color(0xAA232b20),
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = sistol,
                onValueChange = { sistol = it },
                label = { Text("Sistol") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xAA232b20),
                    placeholderColor = Color(0xAA232b20),
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = diastol,
                onValueChange = { diastol = it },
                label = { Text("Diastol") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xAA232b20),
                    placeholderColor = Color(0xAA232b20),
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = glukosa,
                onValueChange = { glukosa = it },
                label = { Text("Glukosa") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xAA232b20),
                    placeholderColor = Color(0xAA232b20),
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = asamUrat,
                onValueChange = { asamUrat = it },
                label = { Text("Asam Urat") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xAA232b20),
                    placeholderColor = Color(0xAA232b20),
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = kolesterol,
                onValueChange = { kolesterol = it },
                label = { Text("Kolesterol") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xAA232b20),
                    placeholderColor = Color(0xAA232b20),
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    // Validasi input
                    if (nama.isNotBlank() && bb.isNotBlank() && tb.isNotBlank() &&
                        tensi.isNotBlank() && sistol.isNotBlank() && diastol.isNotBlank() &&
                        glukosa.isNotBlank() && asamUrat.isNotBlank() && kolesterol.isNotBlank()) {

                        // Simpan data ke database
                        val result = databaseHelper.insertHealthData(
                            nama,
                            bb,
                            tb,
                            tensi,
                            sistol,
                            diastol,
                            glukosa,
                            asamUrat,
                            kolesterol
                        )

                        // Tampilkan pesan konfirmasi
                        if (result != -1L) { // Jika penyimpanan berhasil
                            Toast.makeText(context, "Data kesehatan berhasil disimpan!", Toast.LENGTH_SHORT).show()
                            navController.navigate("home") // Ganti dengan rute yang sesuai
                        } else {
                            Toast.makeText(context, "Gagal menyimpan data kesehatan.", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(context, "Mohon lengkapi semua data!", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xAAafd8a3),
                    contentColor = Color(0xAA232b20)
                )
            ) {
                Text("Simpan Data")
            }
        }
    }
}