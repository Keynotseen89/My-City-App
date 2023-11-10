package com.example.mycityapp.data

import com.example.mycityapp.model.Recommendation
import com.example.mycityapp.R

/**
 * Restaurant Data
 */
object RestaurantDataProvider {
    val defaultRestaurant = getRecommendedRestaurant()[0]
    fun getRecommendedRestaurant(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 1,
                titleResourcesId = R.string.restaurant_orochon_ramen,
                subtitleResourceId = R.string.restaurant_orochon_ramen_subtitle,
                imageResourceId = R.drawable.restaurant_orochon_ramen,
                recommendedImageBanner = R.drawable.restaurant_orochon_banner,
                recommendedHours = R.string.restaurant_orochon_ramen_hours,
                recommendedDetails = R.string.restaurant_orochon_ramen_details,
                recommendedLocation = R.string.restaurant_orochon_ramen_location
            ),
            Recommendation(
                id = 2,
                titleResourcesId = R.string.restaurant_slurpin_ramen_bar,
                subtitleResourceId = R.string.restaurant_slurpin_ramen_bar_subtitle,
                imageResourceId = R.drawable.restaurant_slurpin_ramen,
                recommendedImageBanner = R.drawable.restaurant_slurpin_ramen_banner,
                recommendedHours = R.string.restaurant_slurpin_ramen_bar_hours,
                recommendedDetails = R.string.restaurant_slurpin_ramen_bar_details,
                recommendedLocation = R.string.restaurant_slurpin_ramen_bar_location
            ),
            Recommendation(
                id = 3,
                titleResourcesId = R.string.restaurant_native_fields,
                subtitleResourceId = R.string.restaurant_native_fields_subtitle,
                imageResourceId = R.drawable.restaurant_native_field,
                recommendedImageBanner = R.drawable.restaurant_native_field_banner,
                recommendedHours = R.string.restaurant_native_fields_hours,
                recommendedDetails = R.string.restaurant_native_fields_details,
                recommendedLocation = R.string.restaurant_native_fields_location
            ),
            Recommendation(
                id = 4,
                titleResourcesId = R.string.restaurant_the_chessecake_factory,
                subtitleResourceId = R.string.restaurant_the_cheesecake_factory_subtitle,
                imageResourceId = R.drawable.restaurant_the_cheesecake_factory,
                recommendedImageBanner = R.drawable.restaurant_the_cheesecake_factory_banner,
                recommendedHours = R.string.restaurant_the_cheesecake_factory_hours,
                recommendedDetails = R.string.restaurant_the_cheesecake_factory_details,
                recommendedLocation = R.string.restaurant_the_cheesecake_factory_location
            ),
            Recommendation(
                id = 5,
                titleResourcesId = R.string.restaurant_viva_madrid,
                subtitleResourceId = R.string.restaurant_viva_madrid_subtitle,
                imageResourceId = R.drawable.restaurant_viva_madrid,
                recommendedImageBanner = R.drawable.restaurant_viv_madrid_banner,
                recommendedHours = R.string.restaurant_viva_madrid_hours,
                recommendedDetails = R.string.restaurant_viva_madrid_details,
                recommendedLocation = R.string.restaurant_viva_madrid_location
            ),
            Recommendation(
                id = 6,
                titleResourcesId = R.string.restaurant_little_sister,
                subtitleResourceId = R.string.restaurant_little_sister_subtitle,
                imageResourceId = R.drawable.restaurant_little_sister,
                recommendedImageBanner = R.drawable.restaurant_little_sister_banner,
                recommendedHours = R.string.restaurant_little_sister_hours,
                recommendedDetails = R.string.restaurant_little_sister_details,
                recommendedLocation = R.string.restaurant_little_sister_location
            ),
            Recommendation(
                id = 7,
                titleResourcesId = R.string.restaurant_mama_por_dios,
                subtitleResourceId = R.string.restaurant_mama_por_dios_subtitle,
                imageResourceId = R.drawable.restaurant_mama_por_dios,
                recommendedImageBanner = R.drawable.restaurant_mama_por_dios_banner,
                recommendedHours = R.string.restaurant_mama_por_dios_hours,
                recommendedDetails = R.string.restaurant_mama_por_dios_details,
                recommendedLocation = R.string.restaurant_mama_por_dios_location
            )
        )
    }
}