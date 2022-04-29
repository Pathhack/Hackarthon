package com.pnu.hackarthon.presentation.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.pnu.hackarthon._constant.UIConstant
import com.pnu.hackarthon.presentation.currentRoute

@Composable
fun AppBottomNavigation(
    navController: NavController
) {
    val currentRoute = currentRoute(navController = navController)
    BottomNavigation(
        modifier = Modifier.height(UIConstant.HEIGHT_BOTTOM_BAR)
    ) {
        BottomNavigationItem(
            selected = currentRoute == "추가바람",
            icon = {
                Icon(
                    modifier = Modifier.size(UIConstant.SIZE_ICON_LARGE),
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = ""
                )
            },
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            selected = currentRoute == "추가바람!",
            icon = {
                Icon(
                    modifier = Modifier.size(UIConstant.SIZE_ICON_LARGE),
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = ""
                )
            },
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            selected = currentRoute == "추가바람!!",
            icon = {
                Icon(
                    modifier = Modifier.size(UIConstant.SIZE_ICON_LARGE),
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = ""
                )
            },
            onClick = { /*TODO*/ }
        )
    }
}