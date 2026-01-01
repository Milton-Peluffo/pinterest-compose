package com.tomildev.pinterest_compose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tomildev.pinterest_compose.data.model.Pin
import com.tomildev.pinterest_compose.data.source.ImagePins
import com.tomildev.pinterest_compose.ui.components.PinterestCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier, onShowPinMenu: (pin: Pin) -> Unit
) {

    val pins = remember { ImagePins.getRandomPins() }

    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(3.dp),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(pins) { pin ->
            PinterestCard(
                pin = pin,
                onMoreClick = {
                    onShowPinMenu(pin)
                }
            )
        }
    }
}