package com.tomildev.pinterest_compose.ui.components.overflow.PinOverflow

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomildev.pinterest_compose.R
import com.tomildev.pinterest_compose.data.model.Pin
import com.tomildev.pinterest_compose.ui.theme.Gray

//expanded: Boolean, onDismiss: () -> Unit

@Composable
fun PinOveflowMenu(
    pin: Pin,
    onDismiss: () -> Unit
) {

    val itemList = listOf(
        PinOverflowItem(
            icon = R.drawable.ic_pin,
            title = "Guardar"
        ),
        PinOverflowItem(
            icon = R.drawable.ic_share,
            title = "Compartir"
        ),
        PinOverflowItem(
            icon = R.drawable.ic_download,
            title = "Descargar imagen"
        ),
        PinOverflowItem(
            icon = R.drawable.ic_heart,
            title = "Ver mas como esto"
        ),
        PinOverflowItem(
            icon = R.drawable.ic_eye_slash,
            title = "Ver menos como esto"
        ),
        PinOverflowItem(
            icon = R.drawable.ic_circle_slash,
            title = "Reportar Pin",
            subtitle = "Infrige las Direcrices para la comunidad de Pinterest"
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Box(
            Modifier
                .fillMaxWidth()
                .height(450.dp),
            contentAlignment = Alignment.TopCenter
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Gray
                )
            ) {

                Column(modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)) {
                    Icon(
                        painter = painterResource(R.drawable.ic_close),
                        contentDescription = null,
                        Modifier
                            .size(35.dp)
                            .clickable(
                                onClick = { onDismiss() },
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ),
                        tint = Color.White,
                    )
                    Spacer(Modifier.padding(vertical = 16.dp))
                    itemList.forEachIndexed { index, item ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = item.title,
                                Modifier.size(20.dp),
                                tint = Color.White
                            )
                            Spacer(Modifier.padding(horizontal = 8.dp))
                            Column(verticalArrangement = Arrangement.Top) {
                                Text(
                                    text = item.title,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                item.subtitle?.let {
                                    Text(
                                        text = it,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

//                AsyncImage(
//                    model = "https://picsum.photos/400/600",
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                )
                Text(
                    "Este Pin está  inspirado en tu actividad reciente",
                    fontSize = 13.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}