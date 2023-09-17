package com.example.mycityapp.data

import com.example.mycityapp.model.Categories
import com.example.mycityapp.R

/**
 * Category Data
 */
object CategoryDataProvider {
    val defaultCategory = getCategory()[0]
    fun getCategory(): List<Categories> {

        return listOf(
            Categories(
                id = 1,
                titleResourceId = R.string.coffee_shops,
                imageResourceId = R.drawable.coffee_category,
            ),
            Categories(
                id = 2,
                titleResourceId = R.string.restaurants,
                imageResourceId = R.drawable.restaurants_cetgory_image,
            ),
            Categories(
                id = 3,
                titleResourceId = R.string.dog_friendly,
                imageResourceId = R.drawable.dog_friendly_category,
            ),
            Categories(
                id = 4,
                titleResourceId = R.string.dog_parks,
                imageResourceId = R.drawable.dog_park_category,
            ),
            Categories(
                id = 5,
                titleResourceId = R.string.shopping_center,
                imageResourceId = R.drawable.shopping_center_category
            )

        )
    }
}