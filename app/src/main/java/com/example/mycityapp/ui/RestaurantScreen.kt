package com.example.mycityapp.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.R
import com.example.mycityapp.data.RestaurantDataProvider
import com.example.mycityapp.model.Recommendation
import com.example.mycityapp.ui.theme.MyCityAppTheme

@Composable
fun RestaurantList(
    recommended: List<Recommendation>,
    onClick: (Recommendation) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
){
    BackHandler {
        onBackPressed()
    }
    //var scrollState = rememberScrollState()
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier
    ){
        items(recommended, key = { restaurants -> restaurants.id}) { restaurants ->
            RestaurantListItem(
                recommended = restaurants,
                onItemClick = onClick
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RestaurantListItem(
    recommended: Recommendation,
    onItemClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(recommended)}
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            RestaurantListImageItem(
                recommended = recommended,
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
                    text = stringResource(recommended.titleResourcesId),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                )
                Text(
                    text = stringResource(recommended.subtitleResourceId),
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
                Spacer(Modifier.weight(1f))
                Row {
                    Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun RestaurantListImageItem(
    recommended: Recommendation,
    modifier: Modifier = Modifier){
    Box(
        modifier = modifier
    ){
        Image(
            modifier = modifier
                .size(dimensionResource(id = R.dimen.card_image_height))
                .padding(dimensionResource(id = R.dimen.padding_small))
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.shape_rounded_corner_small))),
            painter = painterResource(recommended.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun RestaurantDetail(
    selectedRecommendation: Recommendation,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
){
    BackHandler {
        onBackPressed()
    }
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .verticalScroll(state = scrollState)
    ){
        Column{
            Box{
                Box{
                    Image(
                        painter = painterResource(selectedRecommendation.recommendedImageBanner),
                        contentDescription = null,
                        alignment = Alignment.TopCenter,
                        contentScale =  ContentScale.FillWidth,
                    )
                }
                Column(
                    Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Transparent, MaterialTheme.colorScheme.scrim),
                                0f,
                                400f
                            )
                        )
                ){
                    Text(
                        text = stringResource(selectedRecommendation.titleResourcesId),
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        modifier = Modifier
                            .padding(horizontal = dimensionResource(R.dimen.padding_small))
                    )
                    Row(
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    ){
                        Text(
                            text = stringResource(selectedRecommendation.recommendedHours),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.inverseOnSurface,
                            modifier = Modifier
                                .padding(horizontal = dimensionResource(R.dimen.padding_small))
                        )
                        Spacer(Modifier.weight(1f))

                    }
                }
            } //Finish up the box in a while
            Text(
                text = stringResource(selectedRecommendation.recommendedDetails),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(
                    vertical = dimensionResource(R.dimen.padding_detail_content_vertical),
                    horizontal = dimensionResource(R.dimen.padding_detail_content_horizontal)
                )
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = stringResource(R.string.location_text) + " " + stringResource(selectedRecommendation.recommendedLocation),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(
                    vertical = dimensionResource(R.dimen.padding_detail_content_vertical),
                    horizontal = dimensionResource(R.dimen.padding_detail_content_horizontal )
                )
            )
        }
    }
}

@Composable
fun RestaurantListAndDetail(
    recommended: List<Recommendation>,
    selectedRecommendation: Recommendation,
    onClick: (Recommendation) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
){
    BackHandler {
        onBackPressed()
    }
    Row(
        modifier = modifier
    ){
        RestaurantList(
            recommended = recommended,
            modifier = Modifier.weight(2f),
            onBackPressed = onBackPressed,
            onClick = onClick
        )

        RestaurantDetail(
            selectedRecommendation = selectedRecommendation,
            modifier = Modifier.weight(3f),
            onBackPressed = onBackPressed
        )
    }
}
@Preview
@Composable
fun RestaurantListPreview(){
    MyCityAppTheme{
        Surface{
            RestaurantList(
                recommended = RestaurantDataProvider.getRecommendedRestaurant(),
                onBackPressed = {},
                onClick = {})
        }
    }
}

@Preview
@Composable
fun RestaurantDetailPreview(){
    MyCityAppTheme {
        Surface {
            RestaurantDetail(
                selectedRecommendation = RestaurantDataProvider.getRecommendedRestaurant()[0],
                onBackPressed = {}
            )
        }
    }
}

@Preview
@Composable
fun RestaurantListAndDetailPreview(){
    MyCityAppTheme{
        Surface {
            RestaurantListAndDetail(
                recommended = RestaurantDataProvider.getRecommendedRestaurant(),
                selectedRecommendation = RestaurantDataProvider.getRecommendedRestaurant()[0],
                onClick = {},
                onBackPressed = {},
                modifier = Modifier.fillMaxWidth())
        }
    }
}
