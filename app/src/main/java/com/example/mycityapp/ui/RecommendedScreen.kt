import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.remember
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
import com.example.mycityapp.R
import com.example.mycityapp.data.RecommendationDataProvider
import com.example.mycityapp.model.Recommendation
import com.example.mycityapp.ui.theme.MyCityAppTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RecommendedList(
    recommendation: List<Recommendation>,
    onClick: (Recommendation) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
){
    BackHandler {
        onBackPressed()
    }
    var scrollState = rememberScrollState()
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
        LazyColumn(
            contentPadding = PaddingValues(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            modifier = modifier
        ) {
            Log.d("RECOMMENDED", "Click as been made!")
            items(recommendation, key = { recommended -> recommended.id }) { recommended ->
                RecommendedListItem(
                    recommended = recommended,
                    onItemClick = onClick,
                )
            }
        }
}

/**
 * TODO: Finish up Recommended ListItem
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RecommendedListItem(
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
            RecommendedListImageItem(
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
                    /*Text(
                    text = pluralStringResource(R.plurals.player_count_caption, sport.playerCount, sport.playerCount),
                    style = MaterialTheme.typography.bodySmall
                )*/
                    Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}

/**
 * TODO: Finish up RecommendedListImageItem
 */
@Composable
 private fun RecommendedListImageItem(
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
fun RecommendedListAndDetail(
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
        val activity = (LocalContext.current as Activity)
        RecommendedList(
            recommendation = recommended,
            modifier = Modifier.weight(2f),
            onBackPressed = onBackPressed,
            onClick = onClick
        )

        RecommendedDetail(
            selectedRecommendation = selectedRecommendation,
            modifier = Modifier.weight(3f),
            onBackPressed = onBackPressed
        )
    }
}

@Composable
fun RecommendedDetail(
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
                Box(){
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

@Preview
@Composable
fun RecommendedListPreview(){
    MyCityAppTheme{
        Surface{
            RecommendedList(
                recommendation = RecommendationDataProvider.getRecommendation(),
                onBackPressed = {},
                onClick = {})
        }
    }
}

@Preview
@Composable
fun RecommendedDetailPreview(){
    MyCityAppTheme {
        Surface {
            RecommendedDetail(
                selectedRecommendation = RecommendationDataProvider.getRecommendation()[0],
                onBackPressed = {}
            )
        }
    }
}

@Preview()
@Composable
fun RecommendedListAndDetailPreview(){
    MyCityAppTheme() {
        Surface {
            RecommendedListAndDetail(
                recommended = RecommendationDataProvider.getRecommendation(),
                selectedRecommendation = RecommendationDataProvider.getRecommendation().getOrElse(0){
                    RecommendationDataProvider.defaultRecommendation
                },
                onClick = {},
                onBackPressed = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}