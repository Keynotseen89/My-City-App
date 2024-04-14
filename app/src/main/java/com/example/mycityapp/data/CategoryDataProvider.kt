package com.example.mycityapp.data

import com.example.mycityapp.model.Categories
import com.example.mycityapp.R

/**
 * Category Data
 */
object CategoryDataProvider {
    val getCategory = listOf(
        Categories(
            id = 1,
            titleResourceId = R.string.coffee_shops,
        ),
        Categories(
            id = 2,
            titleResourceId = R.string.restaurants,
        ),
        Categories(
            id = 3,
            titleResourceId = R.string.dog_friendly,
        ),
        Categories(
            id = 4,
            titleResourceId = R.string.dog_parks,
        ),
        Categories(
            id = 5,
            titleResourceId = R.string.shopping_center,
        )
    )
}
