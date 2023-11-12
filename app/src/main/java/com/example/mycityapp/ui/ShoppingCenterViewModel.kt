package com.example.mycityapp.ui


import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.ShoppingCenterDataProvider
import com.example.mycityapp.model.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ShoppingCenterViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        ShoppingCenterUiState(
            shoppingCenterList =ShoppingCenterDataProvider.getShoppingCenterRecommendation(),
            currentShoppingCenter = ShoppingCenterDataProvider.getShoppingCenterRecommendation().getOrElse(0){
                ShoppingCenterDataProvider.defaultShoppingCenterRecommendation
            }
        )
    )

    var uiState: StateFlow<ShoppingCenterUiState> = _uiState

    fun updateCurrentPetFriendly(selectPetFriendly: Recommendation){
        _uiState.update {
            it.copy(currentShoppingCenter = selectPetFriendly)
        }
    }

    fun navigateToPetFriendlyListPage(){
        _uiState.update{
            it.copy(isShowingShoppingCenterList = true)
        }
    }
    fun navigateToPetFriendlyDetailPage(){
        _uiState.update{
            it.copy(isShowingShoppingCenterList = false)
        }
    }
}

data class ShoppingCenterUiState(
    val shoppingCenterList: List<Recommendation> = emptyList(),
    val currentShoppingCenter: Recommendation = ShoppingCenterDataProvider.defaultShoppingCenterRecommendation,
    val isShowingShoppingCenterList: Boolean = true
)