package com.example.mycityapp.ui

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.RecommendationDataProvider
import com.example.mycityapp.model.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RecommendationViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        RecommendationUiState(
            recommendedList = RecommendationDataProvider.getRecommendation(),
            currentRecommended = RecommendationDataProvider.getRecommendation().getOrElse(0){
                RecommendationDataProvider.defaultRecommendation
            },
        )
    )

    var uiState: StateFlow<RecommendationUiState> = _uiState

    fun updateCurrentRecommendation(selectRecommended: Recommendation){
        _uiState.update {
            it.copy(currentRecommended = selectRecommended)
        }
    }

    fun navigateToRecommendedListPage(){
        _uiState.update{
            it.copy(isShowingRecommendedListPage = false)
        }
    }
    fun navigateToRecommendedDetailPage(){
        _uiState.update{
            it.copy(isShowingRecommendedListPage = false)
        }
    }
}

data class RecommendationUiState(
    val recommendedList: List<Recommendation> = emptyList(),
    val currentRecommended: Recommendation = RecommendationDataProvider.defaultRecommendation,
    val isShowingRecommendedListPage: Boolean = true
)