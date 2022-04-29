package com.pnu.hackarthon.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pnu.hackarthon.ui.theme.HackarthonTheme

@Composable
fun QrcodeScreen(
    navController: NavController
) {

}

@Preview
@Composable
fun QrcodeScreenPreview() {
    HackarthonTheme {
        val navController = rememberNavController()
        QrcodeScreen(navController = navController)
    }
}