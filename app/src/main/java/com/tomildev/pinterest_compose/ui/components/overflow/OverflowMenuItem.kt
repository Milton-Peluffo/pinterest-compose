package com.tomildev.pinterest_compose.ui.components.overflow

import androidx.compose.ui.graphics.vector.ImageVector

data class OverflowMenuItem(
    val label: String,
    val icon: ImageVector,
    val onClick: () -> Unit,
    )