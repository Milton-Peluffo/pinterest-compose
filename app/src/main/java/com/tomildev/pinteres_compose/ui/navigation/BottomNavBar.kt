package com.tomildev.pinteres_compose.ui.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavBar() {
    val itemList = listOf<NavItem>(
        NavItem(name = "Home", icon = Icons.Default.Home),
        NavItem(name = "Search", icon = Icons.Default.Search),
        NavItem(name = "Add", icon = Icons.Default.Add),
        NavItem(name = "Inbox", icon = Icons.Default.Email),
        NavItem(name = "Profile", icon = Icons.Default.Person),
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
        icon = { Icon(imageVector = navItem.icon, contentDescription = null) }
    )
}