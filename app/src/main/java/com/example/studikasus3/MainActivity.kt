package com.example.studikasus3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studikasus3.ui.theme.StudiKasus3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudiKasus3Theme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    // LOGIN SCREEN
                    composable("login") {
                        LoginScreen(
                            onLoginClick = { email, password ->
                                navController.navigate("detail/$email/$password")
                            },
                            onDaftarClick = {
                                navController.navigate("hal1")
                            }
                        )
                    }

                    // DETAIL SCREEN
                    composable("detail/{email}/{password}") { backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email") ?: ""
                        val password = backStackEntry.arguments?.getString("password") ?: ""
                        DetailScreen(
                            nim = "235150407111000",
                            nama = "Lathiifahtus Sunniyyah",
                            email = email,
                            onDaftarClick = {
                                navController.navigate("hal1")
                            }
                        )
                    }

                    // HALAMAN DAFTAR
                    composable("hal1") {
                        Hal1Screen { nim, nama, email, tgl, alamat ->
                            navController.navigate("hal2/$nim/$nama/$email/$tgl/$alamat")
                        }
                    }

                    // HALAMAN HASIL REGISTRASI
                    composable("hal2/{nim}/{nama}/{email}/{tgl}/{alamat}") { backStackEntry ->
                        val nim = backStackEntry.arguments?.getString("nim") ?: ""
                        val nama = backStackEntry.arguments?.getString("nama") ?: ""
                        val email = backStackEntry.arguments?.getString("email") ?: ""
                        val tgl = backStackEntry.arguments?.getString("tgl") ?: ""
                        val alamat = backStackEntry.arguments?.getString("alamat") ?: ""

                        Hal2Screen(nim, nama, email, tgl, alamat)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMain() {
    StudiKasus3Theme {
    }
}
