package com.example.mycityapp.data

import com.example.mycityapp.model.Recommendation
import com.example.mycityapp.R
/**
 * Pet Friendly Data
 */
object PetFriendlyDataProvider {
    val defaultPetFriendly = getPetFriendlyRestaurant()[0]
    fun getPetFriendlyRestaurant(): List<Recommendation> {
        return listOf(
            Recommendation(
                id  = 1,
                titleResourcesId = R.string.pet_friendly_pedalers_fork ,
                subtitleResourceId = R.string.pet_friendly_pedalers_fork_subtitle ,
                imageResourceId = R.drawable.pet_friendly_pedalers_fork,
                recommendedImageBanner = R.drawable.pet_friendly_pedalers_fork_banner,
                recommendedHours = R.string.pet_friendly_pedalers_fork_hours,
                recommendedDetails = R.string.pet_friendly_pedalers_fork_details,
                recommendedLocation = R.string.pet_friendly_pedalers_fork_location,
            ),
            Recommendation(
                id  = 2,
                titleResourcesId = R.string.pet_friendly_tallulas,
                subtitleResourceId = R.string.pet_friendly_tallulas_subtitle ,
                imageResourceId = R.drawable.pet_friendly_tallulas,
                recommendedImageBanner = R.drawable.pet_friendly_tallulas_banner,
                recommendedHours = R.string.pet_friendly_tallulas_hours,
                recommendedDetails = R.string.pet_friendly_tallulas_details,
                recommendedLocation = R.string.pet_friendly_tallulas_location,
            ),
            Recommendation(
                id  = 3,
                titleResourcesId = R.string.pet_friendly_sugar_palm_ocean_avenue,
                subtitleResourceId = R.string.pet_friendly_sugar_palm_ocean_avenue_subtitle,
                imageResourceId = R.drawable.pet_friendly_sugar_palm_ocean_avenue,
                recommendedImageBanner = R.drawable.pet_friendly_sugar_palm_ocean_avenue_banner,
                recommendedHours = R.string.pet_friendly_sugar_palm_ocean_avenue_hours,
                recommendedDetails = R.string.pet_friendly_sugar_palm_ocean_avenue_detail,
                recommendedLocation = R.string.pet_friendly_sugar_palm_ocean_avenue_location,
            ),
            Recommendation(
                id  = 4,
                titleResourcesId = R.string.pet_friendly_hermanito,
                subtitleResourceId = R.string.pet_friendly_hermanito_subtitle,
                imageResourceId = R.drawable.pet_friendly_hermanito,
                recommendedImageBanner = R.drawable.pet_friendly_hermanito_banner,
                recommendedHours = R.string.pet_friendly_hermanito_hours,
                recommendedDetails = R.string.pet_friendly_hermanito_detail,
                recommendedLocation = R.string.pet_friendly_hermanito_location,
            ),
            Recommendation(
                id  = 5,
                titleResourcesId = R.string.pet_friendly_highly_likely_cafe,
                subtitleResourceId = R.string.pet_friendly_highly_likely_cafe_subtitle,
                imageResourceId = R.drawable.pet_friendly_highly_likely,
                recommendedImageBanner = R.drawable.pet_friendly_hermanito_banner,
                recommendedHours = R.string.pet_friendly_highly_likely_cafe_hours,
                recommendedDetails = R.string.pet_friendly_highly_likely_cafe_detail,
                recommendedLocation = R.string.pet_friendly_highly_likely_cafe_location,
            ),
            Recommendation(
                id  = 6,
                titleResourcesId = R.string.pet_friendly_momed,
                subtitleResourceId = R.string.pet_friendly_momed_subtitle,
                imageResourceId = R.drawable.pet_friendly_momed,
                recommendedImageBanner = R.drawable.pet_friendly_momed_banner,
                recommendedHours = R.string.pet_friendly_momed_hours,
                recommendedDetails = R.string.pet_friendly_momed_detail ,
                recommendedLocation = R.string.pet_friendly_momed_location,
            )
        )
    }
}