package com.pnu.hackarthon.presentation

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pnu.hackarthon.presentation.model.Size

@Composable
/** 현재 화면의 route를 반환한다. */
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

fun Modifier.size(size: Size) = this.then(
    Modifier.size(width = size.width, height = size.height)
)
