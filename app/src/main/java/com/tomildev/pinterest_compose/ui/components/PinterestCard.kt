package com.tomildev.pinterest_compose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tomildev.pinterest_compose.R
import com.tomildev.pinterest_compose.data.model.Pin

@Composable
fun PinterestCard(
    pin: Pin,
    onMoreClick: () -> Unit
) {

    Column {
        Card(
            shape = RoundedCornerShape(8),
            modifier = Modifier

        ) {
            AsyncImage(
                model = pin.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Spacer(Modifier.height(4.dp))
        Row {
            //TODO: ImageDescription()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_dots),
                    contentDescription = null,
                    Modifier
                        .size(22.dp)
                        .clickable(
                            onClick = { onMoreClick() },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        )
                )
            }
        }
    }
}