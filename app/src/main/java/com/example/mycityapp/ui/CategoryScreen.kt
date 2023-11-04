package com.example.mycityapp.ui

import RecommendedDetail
import RecommendedList
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycityapp.R
import com.example.mycityapp.data.CategoryDataProvider
import com.example.mycityapp.data.RecommendationDataProvider
import com.example.mycityapp.model.Categories
import com.example.mycityapp.ui.theme.MyCityAppTheme


@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
){
    val viewModel: CategoryViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val recommendedViewModel: RecommendationViewModel = viewModel()
    val recommendedUiState by recommendedViewModel.uiState.collectAsState()
    /**
     * Finish Windows Size List
     */
    val contentType = when (windowSize) {
            WindowWidthSizeClass.Compact,
            WindowWidthSizeClass.Medium -> ContentType.ListOnly
            WindowWidthSizeClass.Expanded -> ContentType.ListAndDetail
            else -> ContentType.ListOnly
    }
    Scaffold(
      topBar = {
          MyCityAppBar(
              isShowingCategoryListPage = uiState.isShowingCategoryListPage,
              onBackButtonClick = {},//{ viewModel.navigateToCategoryListPage()},
              windowSize = windowSize,
          )
      }
    ) { innerPadding ->
        if(uiState.isShowingCategoryListPage){
            CategoryList(
                categories = uiState.categoryList,
                onClick = {
                    viewModel.updateCurrentCategory(it)
                    viewModel.navigateToRecommendedPage()
                },
                modifier = Modifier.padding(innerPadding)
            )
        } else {
            if (recommendedUiState.isShowingRecommendedListPage) {
                //Need to revisit this section to clean up
                RecommendedList(
                    recommendation = recommendedUiState.recommendedList,
                    modifier = Modifier.padding(innerPadding),
                    onClick = {
                        recommendedViewModel.updateCurrentRecommendation(it)
                        recommendedViewModel.navigateToRecommendedDetailPage()
                    },
                    onBackPressed = {
                        viewModel.navigateToCategoryListPage()
                    }
                )
            } else {
                RecommendedDetail(selectedRecommendation = recommendedUiState.currentRecommended,
                    onBackPressed = {
                        recommendedViewModel.navigateToRecommendedListPage()
                    })
            }
        }

    }
}

/**
 * TODO: Finish up AppBar by adding windows size
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    onBackButtonClick: () -> Unit,
    isShowingCategoryListPage: Boolean,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    var isShowingRecommendedListPage = windowSize != WindowWidthSizeClass.Expanded && !isShowingCategoryListPage
    TopAppBar(
        title = {
            Text(text = if(isShowingRecommendedListPage) {
                stringResource(R.string.recommended_fragment_label)
            } else {
                stringResource(R.string.category_fragment_label)
            },
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = if (isShowingRecommendedListPage) {
            {
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        } else {
            { Box() {} }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = modifier
    )
}

/**
 *  TODO : Need to fix or import padding_medium for R.dimen
 */
@Composable
private fun CategoryList(
    categories: List<Categories>,
    onClick: (Categories) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier
    ){
        Log.d("CATEGORY","Click as been made!")
        items(categories, key = { category -> category.id }) { category ->
            CategoryListItem(
                category = category,
                onItemClick = onClick
            )
        }

    }
}

/**
 * TODO : Finish up CategoryListItem  layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CategoryListItem(
    category: Categories,
    onItemClick: (Categories) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(category)}
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {

            CategoryListImageItem(
                category = category,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )
            Column(
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(category.titleResourceId),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                )
            }
        }
    }
}

/**
 *  TODO : Need to finish CategoryListImageItem
 */
@Composable
private fun CategoryListImageItem(category: Categories, modifier: Modifier = Modifier){
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(category.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview
@Composable
fun CategoryListPreview(){
    MyCityAppTheme{
        Surface {
            CategoryList(
                categories = CategoryDataProvider.getCategory(),
                onClick = {}
            )
        }
    }

}