package com.example.illabank.domain.model

import androidx.annotation.DrawableRes

data class Trainer(
    val id: Int,
    @DrawableRes val image: Int,
    val name: String
)