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
            label = { Text("235150407111046") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        )

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Lathiifahtus Sunniyyah") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("lathiifahtuss@student.ub.ac.id") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        )

        OutlinedTextField(
            value = tglLahir,
            onValueChange = { tglLahir = it },
            label = { Text("26 Oktober 2003") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Jl. Raya Sumbersari 292C") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
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

        Text(text = "235150407111046 : $nim", fontSize = 18.sp)
        Text(text = "Lathiifahtus Sunniyyah : $nama", fontSize = 18.sp)
        Text(text = "lathiifahtuss@student.ub.ac.id : $email", fontSize = 18.sp)
        Text(text = "26 Oktober 2003 : $tglLahir", fontSize = 18.sp)
        Text(text = "Jl. Raya Sumbersari 292C : $alamat", fontSize = 18.sp)
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
    Hal2Screen("235150407111000", "Lathiifahtus Sunniyyah", "lathiifahtuss@student.ub.ac.id", "26 Oktober", "Jl. Raya Sumbersari 292C")
}
