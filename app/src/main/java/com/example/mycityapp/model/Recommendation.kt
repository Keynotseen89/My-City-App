package com.example.mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendation(
    val id: Int,
    @StringRes val titleResourcesId: Int,
    @StringRes val subtitleResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val recommendedImageBanner: Int,
    @StringRes val recommendedHours: Int,
    @StringRes val recommendedDetails: Int,
    @StringRes val recommendedLocation: Int
)
