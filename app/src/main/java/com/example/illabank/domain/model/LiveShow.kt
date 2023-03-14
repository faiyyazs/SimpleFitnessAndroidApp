package com.example.illabank.domain.model

import androidx.annotation.DrawableRes

data class LiveShow(
    val carouselId: Int,
    @DrawableRes val carouselImage: Int,
)