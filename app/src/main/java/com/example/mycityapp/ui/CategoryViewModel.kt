package com.example.mycityapp.ui

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.CategoryDataProvider
import com.example.mycityapp.model.Categories
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * View Model for My City App
 */
class CategoryViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        CategoryUiState(
            categoryList = CategoryDataProvider.getCategory(),
            currentCategory =  CategoryDataProvider.getCategory().getOrElse(0){
                CategoryDataProvider.defaultCategory
            }
        )
    )
    val uiState: StateFlow<CategoryUiState> = _uiState

    fun updateCurrentCategory(selectCategory: Categories){
        _uiState.update {
            it.copy(currentCategory = selectCategory)
        }
    }

    fun navigateToCategoryListPage(){
        _uiState.update {
            it.copy(isShowingCategoryListPage = true)
        }
    }

    fun navigateToRecommendedPage(){
        _uiState.update{
            it.copy(isShowingCategoryListPage = false)
        }
    }
}

data class CategoryUiState(
    val categoryList: List<Categories> = emptyList(),
    val currentCategory: Categories = CategoryDataProvider.defaultCategory,
    val isShowingCategoryListPage: Boolean = true,
)