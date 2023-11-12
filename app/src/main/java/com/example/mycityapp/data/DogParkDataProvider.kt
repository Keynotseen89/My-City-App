package com.example.mycityapp.data

import com.example.mycityapp.R
import com.example.mycityapp.model.Recommendation

object DogParkDataProvider {

    val defaultDogParkRecommendation  = getDogParkRecommendation()[0]
    fun getDogParkRecommendation(): List<Recommendation> {
        return listOf(
            Recommendation(
                id  = 1,
                titleResourcesId = R.string.dog_parks_the_boneyard,
                subtitleResourceId = R.string.dog_parks_the_boneyard_subtitle,
                imageResourceId = R.drawable.dog_parks_the_boneyard,
                recommendedImageBanner = R.drawable.dog_parks_the_boneyard_banner,
                recommendedHours = R.string.dog_parks_the_boneyard_hours,
                recommendedDetails = R.string.dog_parks_the_boneyard_detail,
                recommendedLocation = R.string.dog_parks_the_boneyard_location,
            ),
            Recommendation(
                id  = 2,
                titleResourcesId = R.string.dog_parks_arts_district_dog_park,
                subtitleResourceId = R.string.dog_parks_arts_district_dog_park_subtitle,
                imageResourceId = R.drawable.dog_parks_art_district,
                recommendedImageBanner = R.drawable.dog_parks_art_district_banner,
                recommendedHours = R.string.dog_parks_arts_district_dog_park_hours,
                recommendedDetails = R.string.dog_parks_arts_district_dog_park_detail,
                recommendedLocation = R.string.dog_parks_arts_district_dog_park_location,
            ),
            Recommendation(
                id  = 3,
                titleResourcesId = R.string.dog_parks_bluff_creek_dog_park,
                subtitleResourceId = R.string.dog_parks_bluff_creek_dog_park_subtitle,
                imageResourceId = R.drawable.dog_parks_bluff_creek_dog_park,
                recommendedImageBanner = R.drawable.dog_parks_bluff_creek_dog_park_banner,
                recommendedHours = R.string.dog_parks_bluff_creek_dog_park_hours,
                recommendedDetails = R.string.dog_parks_bluff_creek_dog_park_detail,
                recommendedLocation = R.string.dog_parks_bluff_creek_dog_park_location,
            ),
            Recommendation(
                id  = 4,
                titleResourcesId = R.string.dog_parks_griffith_park_dog_park,
                subtitleResourceId = R.string.dog_parks_griffith_park_dog_park_subtitle,
                imageResourceId = R.drawable.dog_parks_griffith_park_dog_park,
                recommendedImageBanner = R.drawable.dog_parks_griffith_park_dog_park_banner,
                recommendedHours = R.string.dog_parks_griffith_park_dog_park_hours,
                recommendedDetails = R.string.dog_parks_griffith_park_dog_park_detail,
                recommendedLocation = R.string.dog_parks_griffith_park_dog_park_location,
            ),
            Recommendation(
                id  = 5,
                titleResourcesId = R.string.dog_parks_sepulveda_basin_off_leash_dog_park,
                subtitleResourceId = R.string.dog_parks_sepulveda_basin_off_leash_dog_park_subtitle,
                imageResourceId = R.drawable.dog_parks_sepulveda_basin_off_leash_dog_park,
                recommendedImageBanner = R.drawable.dog_parks_sepulveda_basin_off_leash_dog_park_banner,
                recommendedHours = R.string.dog_parks_sepulveda_basin_off_leash_dog_park_hours,
                recommendedDetails = R.string.dog_parks_sepulveda_basin_off_leash_dog_park_detail,
                recommendedLocation = R.string.dog_parks_sepulveda_basin_off_leash_dog_park_location,
            ),
            Recommendation(
                id  = 6,
                titleResourcesId = R.string.dog_parks_lake_hollywood_park,
                subtitleResourceId = R.string.dog_parks_lake_hollywood_park_subtitle,
                imageResourceId = R.drawable.dog_parks_lake_hollywood_park,
                recommendedImageBanner = R.drawable.dog_parks_lake_hollywood_park_banner,
                recommendedHours = R.string.dog_parks_lake_hollywood_park_hours,
                recommendedDetails = R.string.dog_parks_lake_hollywood_park_detail,
                recommendedLocation = R.string.dog_parks_lake_hollywood_park_location,
            ),
            Recommendation(
                id  = 7,
                titleResourcesId = R.string.dog_parks_silver_lake_dog_park,
                subtitleResourceId = R.string.dog_parks_silver_lake_dog_park_subtitle,
                imageResourceId = R.drawable.dog_parks_silver_lake_dog_park,
                recommendedImageBanner = R.drawable.dog_parks_silver_lake_dog_park,
                recommendedHours = R.string.dog_parks_silver_lake_dog_park_hours,
                recommendedDetails = R.string.dog_parks_silver_lake_dog_park_detail,
                recommendedLocation = R.string.dog_parks_silver_lake_dog_park_location,
            ),
            Recommendation(
                id  = 8,
                titleResourcesId = R.string.dog_parks_runyon_canyon_dog_park,
                subtitleResourceId = R.string.dog_parks_runyon_canyon_dog_park_subtitle,
                imageResourceId = R.drawable.dog_parks_runyon_canyon_dog_park,
                recommendedImageBanner = R.drawable.dog_parks_runyon_canyon_dog_park_banner,
                recommendedHours = R.string.dog_parks_runyon_canyon_dog_park_hours,
                recommendedDetails = R.string.dog_parks_runyon_canyon_dog_park_detail,
                recommendedLocation = R.string.dog_parks_runyon_canyon_dog_park_location,
            )
        )
    }
}