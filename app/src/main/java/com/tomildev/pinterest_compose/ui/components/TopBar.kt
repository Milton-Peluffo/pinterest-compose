package com.tomildev.pinterest_compose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
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

    var selectedIndex by remember { mutableIntStateOf(0) }

    TopAppBar(
        modifier = modifier
            .height(60.dp),
        title = {
            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(23.dp),
            ) {
                itemsIndexed(topBartitles) { index, title ->

                    var textWidth by remember { mutableIntStateOf(0) }

                    Column(
                        modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = title,
                            fontSize = 15.sp,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .onSizeChanged {
                                    textWidth = it.width
                                }
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                )
                                {
                                    selectedIndex = index
                                }
                        )
                        if (index == selectedIndex) {
                            Box(
                                Modifier
                                    .height(2.dp)
                                    .width(with(LocalDensity.current) { textWidth.toDp()})
                                    .background(Color.White)
                            )
                        }
                    }
                }
                item {
                    VerticalDivider(
                        modifier = Modifier.height(20.dp),
                        thickness = 1.5.dp,
                        color = Gray
                    )
                }
                item {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(shape = RoundedCornerShape(35))
                            .background(color = Gray)
                            .clickable(
                                onClick = {},
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_magic),
                            modifier = Modifier.size(16.dp),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    )
}