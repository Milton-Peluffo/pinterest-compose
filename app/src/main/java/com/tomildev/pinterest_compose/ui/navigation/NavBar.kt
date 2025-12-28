package com.tomildev.pinterest_compose.ui.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tomildev.pinterest_compose.R

@Composable
fun NavBar() {
    val itemList = listOf(
        NavItem(name = "Home",
            iconFilled = R.drawable.ic_home_filled,
            iconOutlined = R.drawable.ic_home_outlined),
        NavItem(name = "Search",
            iconFilled = R.drawable.ic_search_thick,
            iconOutlined = R.drawable.ic_search),
        NavItem(name = "Add",
            iconFilled = R.drawable.ic_plus,
            iconOutlined = R.drawable.ic_plus),
        NavItem(name = "Inbox",
            iconFilled = R.drawable.ic_inbox_filled,
            iconOutlined = R.drawable.ic_inbox_outlined),
        NavItem(name = "Profile",
            iconFilled = R.drawable.ic_home_filled,
            iconOutlined = R.drawable.ic_home_filled),
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    NavigationBar(
        modifier = Modifier
            .height(95.dp),
        contentColor = Color.White,
    ) {

        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
        ) {
            itemList.forEachIndexed { index, item ->
                PinterestCompose(navItem = item, isSelected = index == selectedIndex){
                    selectedIndex = index
                }
            }

        }
    }
}

@Composable
fun RowScope.PinterestCompose(navItem: NavItem,isSelected: Boolean, onItemclick: () -> Unit) {

    val iconId = if (isSelected) navItem.iconFilled else navItem.iconOutlined

    NavigationBarItem(
        selected = isSelected,
        onClick = onItemclick,
        icon = {
            Icon(
                modifier = Modifier.size(28.dp),
                painter = painterResource(id = iconId), contentDescription = navItem.name
            )
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.White,
            unselectedIconColor = Color.White,
            indicatorColor = Color.Transparent
        )
    )
}