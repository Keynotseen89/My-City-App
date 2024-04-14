package com.example.mycityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.R
import com.example.mycityapp.data.CategoryDataProvider
import com.example.mycityapp.model.Categories



@Composable
fun StartScreen(
    categoryOptions: List<Categories>,
    onClick: (Categories) -> Unit,
    //onNextButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ){
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Image(
                painter = painterResource(R.drawable.shopping_center_the_grove),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Text(
                text = "Category Screen",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        }
        Row(modifier = Modifier.weight(1f, false)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = R.dimen.padding_medium)
                )
            ) {
                categoryOptions.forEach { item ->
                    SelectQuantityButton(
                        labelResourceId = item ,
                        onClick = onClick )
                }
            }
        }
    }
}



@Composable
fun SelectQuantityButton(
    labelResourceId: Categories,
    onClick: (Categories) -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = { onClick(labelResourceId)},
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text(stringResource(labelResourceId.titleResourceId))
    }
}

@Preview
@Composable
fun StartScreenPreview(){
    StartScreen(
        categoryOptions = CategoryDataProvider.getCategory,
        onClick = {},
        //onNextButtonClicked = {},
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_medium))
    )
}