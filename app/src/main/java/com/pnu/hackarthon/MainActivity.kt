package com.pnu.hackarthon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.pnu.hackarthon.presentation.navigation.NavGraph
import com.pnu.hackarthon.ui.theme.HackarthonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    init {
        instance = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HackarthonTheme {
                val navController = rememberNavController()
                NavGraph(navController)
            }
        }
    }

    companion object {
        lateinit var instance: MainActivity
    }
}