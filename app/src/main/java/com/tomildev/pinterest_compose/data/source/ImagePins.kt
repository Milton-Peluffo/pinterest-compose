package com.tomildev.pinterest_compose.data.source

import com.tomildev.pinterest_compose.data.model.Pin

object ImagePins {

    private val images = listOf(
        "https://picsum.photos/400/600",
        "https://picsum.photos/400/500",
        "https://picsum.photos/400/700",
        "https://picsum.photos/400/450"
    )

    fun getRandomPins(): List<Pin> {
        return List(50) { index ->
            Pin(
                id = index,
                imageUrl = images.random(),
                height = (150..320).random()
            )
        }
    }
}