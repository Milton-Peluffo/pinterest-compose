package com.tomildev.pinterest_compose.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.tomildev.pinterest_compose.data.model.Pin
import com.tomildev.pinterest_compose.ui.components.overflow.PinOverflow.PinOveflowMenu
import com.tomildev.pinterest_compose.ui.navigation.NavBar

@Composable
fun MainAppScreen(modifier: Modifier = Modifier) {

    var isPinMenuVisible by remember { mutableStateOf(false) }
    var selectedPin by remember { mutableStateOf<Pin?>(null) }

    Scaffold(
        bottomBar = {
            if (!isPinMenuVisible) {
                NavBar()
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            HomeScreen(
                modifier = Modifier.padding(innerPadding),
                onShowPinMenu = { pin ->
                    selectedPin = pin
                    isPinMenuVisible = true
                }
            )

            if (isPinMenuVisible && selectedPin != null){
                PinOveflowMenu(
                    pin = selectedPin!!,
                    onDismiss = { isPinMenuVisible = false }
                )
            }
        }
    }

}