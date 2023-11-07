package com.example.mycityapp.data

import com.example.mycityapp.model.Recommendation
import com.example.mycityapp.R
/**
 * Recommended Data
 */
object RecommendationDataProvider {
    val defaultRecommendation = getRecommendation()[0]
    fun getRecommendation(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 1,
                titleResourcesId = R.string.mad_lab_coffee,
                subtitleResourceId = R.string.mad_lab_coffee_subtitle,
                imageResourceId = R.drawable.coffee_category,
                recommendedImageBanner = R.drawable.coffee_category_banner,
                recommendedHours = R.string.mad_lab_coffee_hours,
                recommendedDetails = R.string.mad_lab_coffee_details
            ),
            Recommendation(
                id = 2,
                titleResourcesId = R.string.laidrey_coffee,
                subtitleResourceId = R.string.laidre_coffee_subtitle,
                imageResourceId = R.drawable.laidrey_coffee_cafe,
                recommendedImageBanner = R.drawable.laidrey_coffee_cafe_banner,
                recommendedHours = R.string.laidre_coffee_hours,
                recommendedDetails = R.string.laidre_coffee_details
            ),
            Recommendation(
                id = 3,
                titleResourcesId = R.string.ten_speed_coffee,
                subtitleResourceId = R.string.ten_speed_coffee_subtitle,
                imageResourceId = R.drawable.ten_speed_coffee,
                recommendedImageBanner = R.drawable.ten_speed_coffee_banner,
                recommendedHours = R.string.ten_speed_coffee_hours,
                recommendedDetails = R.string.ten_speed_coffee_details
            ),
            Recommendation(
                id = 4,
                titleResourcesId = R.string.the_boy_and_the_bear,
                subtitleResourceId = R.string.the_boy_and_the_bear_subtitle,
                imageResourceId = R.drawable.the_boy_and_the_bear,
                recommendedImageBanner = R.drawable.the_boy_and_the_bear_banner,
                recommendedHours = R.string.the_boy_and_the_bear_hours,
                recommendedDetails = R.string.the_boy_and_the_bear_details
            ),
            Recommendation(
                id = 5,
                titleResourcesId = R.string.maru_coffee,
                subtitleResourceId = R.string.maru_coffee_subtitle,
                imageResourceId = R.drawable.maru_coffee_shop,
                recommendedImageBanner = R.drawable.maru_coffee_shop_banner,
                recommendedHours = R.string.maru_coffee_hours,
                recommendedDetails = R.string.maru_coffee_details
            ),
        )
    }
}