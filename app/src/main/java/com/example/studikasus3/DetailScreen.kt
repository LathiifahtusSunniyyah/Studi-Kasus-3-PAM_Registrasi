package com.example.studikasus3

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(
    nim: String,
    nama: String,
    email: String,
    onDaftarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Detail Mahasiswa", fontSize = 26.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "NIM : $nim", fontSize = 18.sp)
        Text(text = "Nama : $nama", fontSize = 18.sp)
        Text(text = "Email : $email", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onDaftarClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text("DAFTAR")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen() {
    DetailScreen(
        nim = "235150407111000",
        nama = "Sonia",
        email = "sonia@gmail.com",
        onDaftarClick = {}
    )
}
