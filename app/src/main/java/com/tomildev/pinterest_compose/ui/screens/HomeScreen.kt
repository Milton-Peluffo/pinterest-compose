package com.tomildev.pinterest_compose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tomildev.pinterest_compose.R
import com.tomildev.pinterest_compose.data.source.ImagePins
import com.tomildev.pinterest_compose.ui.components.PinterestCard

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val pins = remember { ImagePins.getRandomPins() }

   Column(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(3.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(pins){ pin ->
                PinterestCard(pin)
            }
        }
       Icon(painter = painterResource(R.drawable.ic_dots), contentDescription = null)
    }
}