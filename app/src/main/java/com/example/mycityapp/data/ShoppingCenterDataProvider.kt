package com.example.mycityapp.data

import com.example.mycityapp.R
import com.example.mycityapp.model.Recommendation

object ShoppingCenterDataProvider {

    val defaultShoppingCenterRecommendation = getShoppingCenterRecommendation()[0]

    fun getShoppingCenterRecommendation(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 1,
                titleResourcesId = R.string.shopping_center_victoria_gardens,
                subtitleResourceId = R.string.shopping_center_victoria_gardens_subtitle,
                imageResourceId =  R.drawable.shopping_center_victoria_gardens,
                recommendedImageBanner = R.drawable.shopping_center_victoria_gardens_banner,
                recommendedHours = R.string.shopping_center_victoria_gardens_hours,
                recommendedDetails = R.string.shopping_center_victoria_gardens_detail,
                recommendedLocation = R.string.shopping_center_victoria_gardens_location
            ),
            Recommendation(
                id = 2,
                titleResourcesId = R.string.shopping_center_ontario_mills,
                subtitleResourceId = R.string.shopping_center_ontario_mills_subtitle,
                imageResourceId =  R.drawable.shopping_center_ontario_mills,
                recommendedImageBanner = R.drawable.shopping_center_ontario_mills_banner,
                recommendedHours = R.string.shopping_center_ontario_mills_hours,
                recommendedDetails = R.string.shopping_center_ontario_mills_detail,
                recommendedLocation = R.string.shopping_center_ontario_mills_location
            ),
            Recommendation(
                id = 3,
                titleResourcesId = R.string.shopping_center_the_grove,
                subtitleResourceId = R.string.shopping_center_the_grove_subtitle,
                imageResourceId =  R.drawable.shopping_center_the_grove,
                recommendedImageBanner = R.drawable.shopping_center_the_grove_banner,
                recommendedHours = R.string.shopping_center_the_grove_hours,
                recommendedDetails = R.string.shopping_center_the_grove_detail,
                recommendedLocation = R.string.shopping_center_the_grove_location
            ),
            Recommendation(
                id = 4,
                titleResourcesId = R.string.shopping_center_south_coast_plaza,
                subtitleResourceId = R.string.shopping_center_south_coast_plaza_subtitle,
                imageResourceId =  R.drawable.shopping_center_south_coast_plaza,
                recommendedImageBanner = R.drawable.shopping_center_south_coast_plaza_banner,
                recommendedHours = R.string.shopping_center_south_coast_plaza_hours,
                recommendedDetails = R.string.shopping_center_south_coast_plaza_detail,
                recommendedLocation = R.string.shopping_center_south_coast_plaza_location
            ),
            Recommendation(
                id = 5,
                titleResourcesId = R.string.shopping_center_hollywood_and_highland,
                subtitleResourceId = R.string.shopping_center_hollywood_and_highland_subtitle,
                imageResourceId =  R.drawable.shopping_center_hollywood_and_highland,
                recommendedImageBanner = R.drawable.shopping_center_hollywood_and_highland_banner,
                recommendedHours = R.string.shopping_center_hollywood_and_highland_hours,
                recommendedDetails = R.string.shopping_center_hollywood_and_highland_detail,
                recommendedLocation = R.string.shopping_center_hollywood_and_highland_location
            ),
            Recommendation(
                id = 6,
                titleResourcesId = R.string.shopping_center_santa_monica_place,
                subtitleResourceId = R.string.shopping_center_santa_monica_place_subtitle,
                imageResourceId =  R.drawable.shopping_center_santa_monica_place,
                recommendedImageBanner = R.drawable.shopping_center_santa_monica_place_banner,
                recommendedHours = R.string.shopping_center_santa_monica_place_hours,
                recommendedDetails = R.string.shopping_center_santa_monica_place_detail,
                recommendedLocation = R.string.shopping_center_santa_monica_place_location
            )
        )
    }
}