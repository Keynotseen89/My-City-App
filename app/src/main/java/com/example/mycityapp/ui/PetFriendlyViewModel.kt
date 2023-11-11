package com.example.mycityapp.ui

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.PetFriendlyDataProvider
import com.example.mycityapp.model.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class PetFriendlyViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        PetFriendlyUiState(
            petFriendlyList = PetFriendlyDataProvider.getPetFriendlyRestaurant(),
            currentPetFriendly = PetFriendlyDataProvider.getPetFriendlyRestaurant().getOrElse(0){
                PetFriendlyDataProvider.defaultPetFriendly
            }
        )
    )

    var uiState: StateFlow<PetFriendlyUiState> = _uiState

    fun updateCurrentPetFriendly(selectPetFriendly: Recommendation){
        _uiState.update {
            it.copy(currentPetFriendly = selectPetFriendly)
        }
    }

    fun navigateToPetFriendlyListPage(){
        _uiState.update{
            it.copy(isShowingPetFriendlyList = true)
        }
    }
    fun navigateToPetFriendlyDetailPage(){
        _uiState.update{
            it.copy(isShowingPetFriendlyList = false)
        }
    }
}

data class PetFriendlyUiState(
    val petFriendlyList: List<Recommendation> = emptyList(),
    val currentPetFriendly: Recommendation = PetFriendlyDataProvider.defaultPetFriendly,
    val isShowingPetFriendlyList: Boolean = true
)