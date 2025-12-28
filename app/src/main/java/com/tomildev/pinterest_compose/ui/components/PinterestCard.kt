package com.tomildev.pinterest_compose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tomildev.pinterest_compose.data.model.Pin

@Composable
fun PinterestCard(
    pin: Pin
//    = Pin(
//        id = 1,
//        imageUrl = "https://picsum.dev/400/300?grayscale=1",
//        height = 200
//    )
) {

    Card(
        shape = RoundedCornerShape(8),
//        modifier = Modifier
//            .fillMaxWidth()
//            .size(100.dp)
    ) {
        AsyncImage(
            model = pin.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(pin.height.dp)
        )
    }
}