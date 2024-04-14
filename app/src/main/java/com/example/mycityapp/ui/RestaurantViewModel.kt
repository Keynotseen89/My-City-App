package com.example.mycityapp.ui

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.RestaurantDataProvider
//import com.example.mycityapp.model.Categories
import com.example.mycityapp.model.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RestaurantViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        RestaurantUiState(
            restaurantList = RestaurantDataProvider.getRecommendedRestaurant(),
            currentRestaurant = RestaurantDataProvider.getRecommendedRestaurant().getOrElse(0){
                RestaurantDataProvider.defaultRestaurant
            },
        )
    )
    var uiState: StateFlow<RestaurantUiState> = _uiState

    fun updateCurrentRestaurant(selectRestaurant: Recommendation){
        _uiState.update {
            it.copy(currentRestaurant = selectRestaurant)
        }
    }

    fun navigateToRestaurantListPage(){
        _uiState.update{
            it.copy(isShowingRestaurantListPage = true)
        }
    }
    fun navigateToRestaurantDetailPage(){
        _uiState.update{
            it.copy(isShowingRestaurantListPage = false)
        }
    }
}

data class RestaurantUiState(
    val restaurantList: List<Recommendation> = emptyList(),
    val currentRestaurant: Recommendation = RestaurantDataProvider.defaultRestaurant,
    val isShowingRestaurantListPage: Boolean = true
)