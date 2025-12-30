package com.tomildev.pinterest_compose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomildev.pinterest_compose.R
import com.tomildev.pinterest_compose.ui.theme.Gray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {

    val topBartitles = listOf(
        "Para ti",
        "Hoy",
        "Moda",
        "Autos",
        "Viajes",
        "Naturaleza",
        "Pixel Art",
        "Fauna",
        "Digital Art",
    )
    TopAppBar(
        modifier = modifier
            .height(60.dp),
        title = {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(25.dp),
            ) {
                items(topBartitles) { title ->
                    Text(
                        text = title,
                        fontSize = 15.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {})
                    )
                }
                item {
                    Button(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.ic_magic),
                            modifier = Modifier.size(25.dp),
                            tint = Gray,
                            contentDescription = null
                        )
                    }
                }
            }
        },
    )
}