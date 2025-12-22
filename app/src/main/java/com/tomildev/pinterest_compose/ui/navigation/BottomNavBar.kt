package com.tomildev.pinterest_compose.ui.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.tomildev.pinterest_compose.R

@Composable
fun BottomNavBar() {
    val itemList = listOf<NavItem>(
        NavItem(name = "Home", icon = painterResource(R.drawable.ic_home_filled)),
        NavItem(name = "Search", icon = painterResource(R.drawable.ic_home_filled)),
        NavItem(name = "Add", icon = painterResource(R.drawable.ic_home_filled)),
        NavItem(name = "Inbox", icon = painterResource(R.drawable.ic_home_filled)),
        NavItem(name = "Profile", icon = painterResource(R.drawable.ic_home_filled)),
    )

var selectedIndex by remember { mutableIntStateOf(0) }

    NavigationBar(
        contentColor = Color.White
    ) {
        itemList.forEachIndexed { index, item ->
            PinterestCompose(navItem = item, isSelected = index == selectedIndex){
                selectedIndex = index
            }
        }
    }
}

@Composable
fun RowScope.PinterestCompose(navItem: NavItem,isSelected: Boolean, onItemclick: () -> Unit) {

    NavigationBarItem(
        selected = false,
        onClick = {},
        icon = { Icon(navItem.icon, contentDescription = "") }
    )
}