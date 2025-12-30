package com.tomildev.pinterest_compose.data.source

import com.tomildev.pinterest_compose.data.model.Pin

object ImagePins {

    val imageUrls = listOf(
        "https://picsum.photos/400/600",
        "https://picsum.photos/400/500",
        "https://picsum.photos/400/700",
        "https://picsum.photos/400/450",
        "https://picsum.photos/400/650",
        "https://picsum.photos/400/550",
        "https://picsum.photos/400/750",
        "https://picsum.photos/400/480",
        "https://picsum.photos/400/620",
        "https://picsum.photos/400/580",
        "https://picsum.photos/400/720",
        "https://picsum.photos/400/460",
        "https://picsum.photos/400/690",
        "https://picsum.photos/400/530",
        "https://picsum.photos/400/800",
        "https://picsum.photos/400/510",
        "https://picsum.photos/400/670",
        "https://picsum.photos/400/590",
        "https://picsum.photos/400/740",
        "https://picsum.photos/400/430"
    )

    fun getRandomPins(): List<Pin> {
        return List(50) { index ->
            Pin(
                id = index,
                imageUrl = imageUrls.random(),
                height = (150..320).random()
            )
        }
    }
}