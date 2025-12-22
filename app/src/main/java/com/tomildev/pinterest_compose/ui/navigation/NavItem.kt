package com.tomildev.pinterest_compose.ui.navigation

import androidx.annotation.DrawableRes

data class NavItem(
    val name: String,
    @DrawableRes val iconFilled: Int,
    @DrawableRes val iconOutlined: Int)