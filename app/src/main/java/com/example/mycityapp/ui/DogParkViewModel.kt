package com.example.mycityapp.ui

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.DogParkDataProvider
import com.example.mycityapp.data.PetFriendlyDataProvider
import com.example.mycityapp.model.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class DogParkViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        DogParkUiState(
            dogParkList = DogParkDataProvider.getDogParkRecommendation(),
            currentDogPark = PetFriendlyDataProvider.getPetFriendlyRestaurant().getOrElse(0){
                PetFriendlyDataProvider.defaultPetFriendly
            }
        )
    )

    var uiState: StateFlow<DogParkUiState> = _uiState

    fun updateCurrentDogPark(selectPetFriendly: Recommendation){
        _uiState.update {
            it.copy(currentDogPark = selectPetFriendly)
        }
    }

    fun navigateToDogParkListPage(){
        _uiState.update{
            it.copy(isShowingDogParkList = true)
        }
    }
    fun navigateToDogParkDetailPage(){
        _uiState.update{
            it.copy(isShowingDogParkList = false)
        }
    }
}

data class DogParkUiState(
    val dogParkList: List<Recommendation> = emptyList(),
    val currentDogPark: Recommendation = PetFriendlyDataProvider.defaultPetFriendly,
    val isShowingDogParkList: Boolean = true
)