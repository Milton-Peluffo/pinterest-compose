package com.tomildev.pinterest_compose.ui.components.overflow

import androidx.compose.runtime.Composable

@Composable
fun OverflowMenu(
    expanded: Boolean,
    onDismiss: () -> Unit,
    items: List<OverflowMenuItem>
){}