package com.example.cinemate.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cinemate.R
import com.example.cinemate.di.Injection
import com.example.cinemate.ui.common.UiState
import com.example.cinemate.ui.model.DetailViewModel
import com.example.cinemate.ui.model.ViewModelFactory
import com.example.cinemate.ui.theme.CinemateTheme

@Composable
fun Detail(
    movieId: Long,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
    navigateBack: () -> Unit,
){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getRewardById(movieId)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data.poster,
                    data.release,
                    data.rating,
                    data.country,
                    data.duration,
                    data.title,
                    data.genre1,
                    data.genre2,
                    data.synopsys,
                    onBackClick = navigateBack,
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    @DrawableRes
    poster: Int,
    release: String,
    rating: String,
    country: String,
    duration: String,
    title: String,
    genre1: String,
    genre2: String,
    synopsys: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        val cardBottom = Modifier
            .padding(bottom = 12.dp)
        val columnModifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E2747))
            .padding(8.dp)
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .background(Color(0xFF141A32))
        ) {

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.back),
                tint = Color.White,
                modifier = Modifier
                    .padding(start = 8.dp, top = 16.dp)
                    .size(32.dp)
                    .clickable { onBackClick() }
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(poster),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .height(310.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                ) {
                    ElevatedCard(
                        modifier = cardBottom,
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.background,
                        ),
                    ) {
                        Column (
                            modifier = columnModifier
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.imdb),
                                    contentDescription = "imdb",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .height(24.dp)
                                )
                                Text(
                                    text = rating,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium,
                                    textAlign = TextAlign.Justify,
                                    fontSize = 18.sp,
                                    modifier = Modifier
                                        .padding(start = 14.dp)
                                )
                                Text(
                                    text = stringResource(R.string.rating),
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium,
                                    textAlign = TextAlign.Justify,
                                    fontSize = 18.sp,
                                )
                            }
                            Image(
                                painter = painterResource(R.drawable.stars),
                                contentDescription = "stars",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .height(24.dp)
                                    .padding(top = 4.dp)
                            )
                        }
                    }
                    ElevatedCard(
                        modifier = cardBottom,
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.background,
                        ),
                    ) {
                        Column (
                            modifier = columnModifier
                        ) {
                            Text(
                                text =stringResource(R.string.duration),
                                color = Color.White.copy(alpha = 0.5f),
                                fontSize = 16.sp,
                                modifier = Modifier
                            )
                            Text(
                                text = duration,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Justify,
                                fontSize = 18.sp,
                                modifier = Modifier
                            )
                        }
                    }
                    ElevatedCard(
                        modifier = cardBottom,
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.background,
                        ),
                    ) {
                        Column (
                            modifier = columnModifier
                        ) {
                            Text(
                                text =stringResource(R.string.release),
                                color = Color.White.copy(alpha = 0.5f),
                                fontSize = 16.sp,
                                modifier = Modifier
                            )
                            Text(
                                text = release,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Justify,
                                fontSize = 18.sp,
                                modifier = Modifier
                            )
                        }
                    }
                    ElevatedCard(
                        modifier = cardBottom,
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.background,
                        ),
                    ) {
                        Column (
                            modifier = columnModifier
                        ) {
                            Text(
                                text =stringResource(R.string.country),
                                color = Color.White.copy(alpha = 0.5f),
                                fontSize = 16.sp,
                                modifier = Modifier
                            )
                            Text(
                                text = country,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Justify,
                                fontSize = 18.sp,
                                modifier = Modifier
                            )
                        }
                    }
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ){
                ElevatedCard(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.background,
                    ),
                    modifier = modifier
                        .padding(end = 12.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color(0xFF1E2747))
                    ) {
                        Text(
                            text = genre1,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Justify,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(start = 32.dp, end = 32.dp, top = 4.dp, bottom = 4.dp),
                        )
                    }
                }
                ElevatedCard(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.background,
                    ),
                    modifier = modifier
                        .padding(end = 12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color(0xFF1E2747))
                    ) {
                        Text(
                            text = genre2,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Justify,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(start = 32.dp, end = 32.dp, top = 4.dp, bottom = 4.dp),
                        )
                    }

                }
            }
            Text(
                text = title,
                color = Color.White,
                maxLines = 2,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.ExtraBold),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp)
            )
            Text(
                text = synopsys,
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailCinemateAppPreview() {
    CinemateTheme {
        DetailContent(R.drawable.poster6, "2023", "8.9", "USA", "2jam 49menit", "Jhon Wick: Chapter 4", "Crime", "Thriller", "John is preparing himself for revenge after he was shot by Winston Scott from the roof of The Continental New York and fell from a height. John Wick, who has Excommunicado status, then looks for a High Table official. Despite being warned that killing the man would not change the situation, John still pulled the trigger",
            onBackClick = {})
    }
}
