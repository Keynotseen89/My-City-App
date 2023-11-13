package com.example.mycityapp.ui

import RecommendedDetail
import RecommendedList
import RecommendedListAndDetail
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycityapp.R
import com.example.mycityapp.data.CategoryDataProvider
import com.example.mycityapp.model.Categories
import com.example.mycityapp.ui.theme.MyCityAppTheme

/*
@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
){
    val viewModel: CategoryViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val recommendedViewModel: RecommendationViewModel = viewModel()
    val recommendedUiState by recommendedViewModel.uiState.collectAsState()

    val restaurantViewModel: RestaurantViewModel = viewModel()
    val restaurantUiState by restaurantViewModel.uiState.collectAsState()

    val petFriendlyViewModel: PetFriendlyViewModel = viewModel()
    val petFriendlyUiState by petFriendlyViewModel.uiState.collectAsState()

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
        }else if(uiState.currentCategory.id == 1){
            if(contentType == ContentType.ListOnly ){
                if(recommendedUiState.isShowingRecommendedListPage ){
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
            else if(contentType == ContentType.ListAndDetail){
                RecommendedListAndDetail(
                    recommended = recommendedUiState.recommendedList,
                    selectedRecommendation = recommendedUiState.currentRecommended,
                    onClick = { recommendedViewModel.updateCurrentRecommendation(it)},
                    onBackPressed = {
                        viewModel.navigateToCategoryListPage()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding)
                )
            }
        } else if(uiState.currentCategory.id == 2){
            if(contentType == ContentType.ListOnly){
                if(restaurantUiState.isShowingRestaurantListPage){
                    RestaurantList(recommended = restaurantUiState.restaurantList,
                        modifier = Modifier.padding(innerPadding),
                        onClick = {
                            restaurantViewModel.updateCurrentRestaurant(it)
                            restaurantViewModel.navigateToRestaurantDetailPage()
                        } ,
                        onBackPressed = {
                            viewModel.navigateToCategoryListPage()
                        })
                } else {
                    RestaurantDetail(selectedRecommendation = restaurantUiState.currentRestaurant,
                        onBackPressed = {
                            restaurantViewModel.navigateToRestaurantListPage()
                        })
                }
            }
            else if(contentType == ContentType.ListAndDetail){
                RestaurantListAndDetail(
                    recommended = restaurantUiState.restaurantList,
                    selectedRecommendation = restaurantUiState.currentRestaurant,
                    onClick = { restaurantViewModel.updateCurrentRestaurant(it)},
                    onBackPressed = {viewModel.navigateToCategoryListPage()},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding)
                )
            }
        } else if(uiState.currentCategory.id == 3){
            if(contentType == ContentType.ListOnly){
                if(petFriendlyUiState.isShowingPetFriendlyList){
                    PetFriendlyList(
                        recommended = petFriendlyUiState.petFriendlyList,
                        modifier = Modifier.padding(innerPadding),
                        onClick = {
                            petFriendlyViewModel.updateCurrentPetFriendly(it)
                            petFriendlyViewModel.navigateToPetFriendlyDetailPage()
                        } ,
                        onBackPressed = {
                            viewModel.navigateToCategoryListPage()
                        })
                } else {
                    PetFriendlyDetail(
                        selectedRecommendation = petFriendlyUiState.currentPetFriendly,
                        onBackPressed = {
                            petFriendlyViewModel.navigateToPetFriendlyListPage()
                        })
                }
            } else if(contentType == ContentType.ListAndDetail) {
                PetFriendlyListAndDetail(
                    recommended = petFriendlyUiState.petFriendlyList,
                    selectedRecommendation = petFriendlyUiState.currentPetFriendly,
                    onClick = { petFriendlyViewModel.updateCurrentPetFriendly(it)},
                    onBackPressed = {
                        viewModel.navigateToCategoryListPage()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding)
                )
            }
        }
    }

}
*/

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
){
    val viewModel: CategoryViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val recommendedViewModel: RecommendationViewModel = viewModel()
    val recommendedUiState by recommendedViewModel.uiState.collectAsState()

    val restaurantViewModel: RestaurantViewModel = viewModel()
    val restaurantUiState by restaurantViewModel.uiState.collectAsState()

    val petFriendlyViewModel: PetFriendlyViewModel = viewModel()
    val petFriendlyUiState by petFriendlyViewModel.uiState.collectAsState()

    val dogParkViewModel: DogParkViewModel = viewModel()
    val dogParkUiState by dogParkViewModel.uiState.collectAsState()

    val shoppingCenterViewModel: ShoppingCenterViewModel = viewModel()
    val shoppingCenterUiState by shoppingCenterViewModel.uiState.collectAsState()

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
        if (contentType == ContentType.ListOnly) {
            if (uiState.isShowingCategoryListPage) {
                CategoryList(
                    categories = uiState.categoryList,
                    onClick = {
                        viewModel.updateCurrentCategory(it)
                        viewModel.navigateToRecommendedPage()
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            } else if (uiState.currentCategory.id == 1) {
                if (recommendedUiState.isShowingRecommendedListPage) {
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
            } else if (uiState.currentCategory.id == 2) {
                if (restaurantUiState.isShowingRestaurantListPage) {
                    RestaurantList(
                        recommended = restaurantUiState.restaurantList,
                        modifier = Modifier.padding(innerPadding),
                        onClick = {
                            restaurantViewModel.updateCurrentRestaurant(it)
                            restaurantViewModel.navigateToRestaurantDetailPage()
                        },
                        onBackPressed = {
                            viewModel.navigateToCategoryListPage()
                        }
                    )
                } else {
                    RestaurantDetail(selectedRecommendation = restaurantUiState.currentRestaurant,
                        onBackPressed = {
                            restaurantViewModel.navigateToRestaurantListPage()
                        })
                }
            } else if (uiState.currentCategory.id == 3) {
                if (petFriendlyUiState.isShowingPetFriendlyList) {
                    PetFriendlyList(
                        recommended = petFriendlyUiState.petFriendlyList,
                        modifier = Modifier.padding(innerPadding),
                        onClick = {
                            petFriendlyViewModel.updateCurrentPetFriendly(it)
                            petFriendlyViewModel.navigateToPetFriendlyDetailPage()
                        },
                        onBackPressed = {
                            viewModel.navigateToCategoryListPage()
                        }
                    )
                } else {
                    PetFriendlyDetail(selectedRecommendation = petFriendlyUiState.currentPetFriendly,
                        onBackPressed = {
                            petFriendlyViewModel.navigateToPetFriendlyListPage()
                        })
                }
            } else if (uiState.currentCategory.id == 4) {
                if (dogParkUiState.isShowingDogParkList) {
                    DogParkList(
                        recommended = dogParkUiState.dogParkList,
                        modifier = Modifier.padding(innerPadding),
                        onClick = {
                            dogParkViewModel.updateCurrentDogPark(it)
                            dogParkViewModel.navigateToDogParkDetailPage()
                        },
                        onBackPressed = {
                            viewModel.navigateToCategoryListPage()
                        }
                    )
                } else {
                    DogParkDetail(selectedRecommendation = dogParkUiState.currentDogPark,
                        onBackPressed = {
                            dogParkViewModel.navigateToDogParkListPage()
                        })
                }
            } else if (uiState.currentCategory.id == 5) {
                if (shoppingCenterUiState.isShowingShoppingCenterList) {
                    ShoppingCenterList(
                        recommended = shoppingCenterUiState.shoppingCenterList,
                        modifier = Modifier.padding(innerPadding),
                        onClick = {
                            shoppingCenterViewModel.updateCurrentShoppingCenter(it)
                            shoppingCenterViewModel.navigateToShoppingCenterDetailPage()
                        },
                        onBackPressed = {
                            viewModel.navigateToCategoryListPage()
                        }
                    )
                } else {
                    ShoppingCenterDetail(
                        selectedRecommendation = shoppingCenterUiState.currentShoppingCenter,
                        onBackPressed = {
                            shoppingCenterViewModel.navigateToShoppingCenterListPage()
                        })
                }
            }
        } else if (contentType == ContentType.ListAndDetail) {
            if (uiState.isShowingCategoryListPage) {
                CategoryList(
                    categories = uiState.categoryList,
                    onClick = {
                        viewModel.updateCurrentCategory(it)
                        viewModel.navigateToRecommendedPage()
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            } else if (uiState.currentCategory.id == 1) {
                RecommendedListAndDetail(
                    recommended = recommendedUiState.recommendedList,
                    selectedRecommendation = recommendedUiState.currentRecommended,
                    onClick = { recommendedViewModel.updateCurrentRecommendation(it) },
                    onBackPressed = {
                        viewModel.navigateToCategoryListPage()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding)
                )
            } else if (uiState.currentCategory.id == 2) {
                RestaurantListAndDetail(
                    recommended = restaurantUiState.restaurantList,
                    selectedRecommendation = restaurantUiState.currentRestaurant,
                    onClick = { restaurantViewModel.updateCurrentRestaurant(it) },
                    onBackPressed = {
                        viewModel.navigateToCategoryListPage()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding)
                )
            } else if (uiState.currentCategory.id == 3) {
                PetFriendlyListAndDetail(
                    recommended = petFriendlyUiState.petFriendlyList,
                    selectedRecommendation = petFriendlyUiState.currentPetFriendly,
                    onClick = { petFriendlyViewModel.updateCurrentPetFriendly(it) },
                    onBackPressed = {
                        viewModel.navigateToCategoryListPage()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding)
                )
            } else if (uiState.currentCategory.id == 4) {
                DogParkListAndDetail(
                    recommended = dogParkUiState.dogParkList,
                    selectedRecommendation = dogParkUiState.currentDogPark,
                    onClick = { dogParkViewModel.updateCurrentDogPark(it) },
                    onBackPressed = {
                        viewModel.navigateToCategoryListPage()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding)
                )
            } else if (uiState.currentCategory.id == 5) {
                ShoppingCenterListAndDetail(
                    recommended = shoppingCenterUiState.shoppingCenterList,
                    selectedRecommendation = shoppingCenterUiState.currentShoppingCenter,
                    onClick = { shoppingCenterViewModel.updateCurrentShoppingCenter(it) },
                    onBackPressed = {
                        viewModel.navigateToCategoryListPage()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding)
                )
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
    val isShowingRecommendedListPage = windowSize != WindowWidthSizeClass.Expanded && !isShowingCategoryListPage
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
            { Box {} }
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
                    style = MaterialTheme.typography.displayMedium,
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
            modifier = modifier
                .size(dimensionResource(id = R.dimen.card_image_height))
                .padding(dimensionResource(id = R.dimen.padding_small))
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.shape_rounded_corner_small))),
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