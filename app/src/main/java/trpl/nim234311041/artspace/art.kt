package trpl.nim234311041.artspace

import androidx.annotation.DrawableRes

data class Art(
    val title: String,
    val Nation: String,
    val year: Int,
    @DrawableRes val imageResId: Int
)