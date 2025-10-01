package com.example.studikasus3

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Hal1Screen(
    modifier: Modifier = Modifier,
    onDaftarClick: (nim: String, nama: String, email: String, tglLahir: String, alamat: String) -> Unit
) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (nama.isEmpty()) "Lathiifahtus Sunniyyah" else nama,
            fontSize = 20.sp
        )
        Text(
            text = if (email.isEmpty()) "lathiifahtuss@student.ub.ac.id" else email,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text("NIM") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        )

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        )

        OutlinedTextField(
            value = tglLahir,
            onValueChange = { tglLahir = it },
            label = { Text("Tanggal Lahir") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // trim supaya data lebih rapi saat dikirim ke MainActivity
                onDaftarClick(
                    nim.trim(),
                    nama.trim(),
                    email.trim(),
                    tglLahir.trim(),
                    alamat.trim()
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text("DAFTAR")
        }
    }
}

@Composable
fun Hal2Screen(
    nim: String,
    nama: String,
    email: String,
    tglLahir: String,
    alamat: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Data Registrasi", fontSize = 26.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "NIM : $nim", fontSize = 18.sp)
        Text(text = "Nama : $nama", fontSize = 18.sp)
        Text(text = "Email : $email", fontSize = 18.sp)
        Text(text = "Tanggal Lahir : $tglLahir", fontSize = 18.sp)
        Text(text = "Alamat : $alamat", fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHal1() {
    Hal1Screen(onDaftarClick = { _, _, _, _, _ -> })
}

@Preview(showBackground = true)
@Composable
fun PreviewHal2() {
    Hal2Screen("235150407111000", "Sonia", "sonia@gmail.com", "01-01-2003", "Sumatra Barat")
}
