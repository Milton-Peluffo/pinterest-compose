package com.tomildev.pinterest_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.tomildev.pinterest_compose.ui.navigation.NavBar
import com.tomildev.pinterest_compose.ui.screens.HomeScreen
import com.tomildev.pinterest_compose.ui.theme.PinterescomposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PinterescomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {NavBar()}
                ) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}