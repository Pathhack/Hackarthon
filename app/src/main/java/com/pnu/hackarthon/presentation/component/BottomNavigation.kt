package com.pnu.hackarthon.presentation.component

import android.content.Intent
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.pnu.hackarthon._constant.UIConstant
import com.pnu.hackarthon.presentation.currentRoute
import com.pnu.hackarthon.presentation.navigation.Screen
import com.pnu.hackarthon.presentation.view.Store
import com.pnu.hackarthon.ui.theme.Purple200
import com.pnu.hackarthon.ui.theme.Purple700

@Composable
fun AppBottomNavigation(
    navController: NavController
) {
    val currentRoute = currentRoute(navController = navController)
    val context = LocalContext.current

    BottomNavigation(
        modifier = Modifier.height(UIConstant.HEIGHT_BOTTOM_BAR),
    ) {
        BottomNavigationItem(
            selected = currentRoute == "추가바람",
            icon = {
                val color =
                    if (currentRoute == "추가바람") Purple700
                    else Purple200
                Icon(
                    modifier = Modifier.size(UIConstant.SIZE_ICON_LARGE),
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "",
                    tint = color
                )
            },
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            selected = (currentRoute == Screen.Home.route),
            icon = {
                val color =
                    if (currentRoute == "추가바람") Purple700
                    else Purple200
                Icon(
                    modifier = Modifier.size(UIConstant.SIZE_ICON_LARGE),
                    imageVector = Icons.Default.Call,
                    contentDescription = "",
                    tint = color
                )
            },
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            selected = currentRoute == "추가바람!!",
            icon = {
                val color =
                    if (currentRoute == "추가바람") Purple700
                    else Purple200
                Icon(
                    modifier = Modifier.size(UIConstant.SIZE_ICON_LARGE),
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "",
                    tint = color
                )
            },
            onClick = {
                val intent = Intent(context, Store::class.java)
                context.startActivity(intent)
            }
        )
    }
}