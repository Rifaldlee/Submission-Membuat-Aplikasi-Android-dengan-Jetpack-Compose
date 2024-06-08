package com.example.cinemate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemate.R

@Composable
fun MovieItem(
    poster: Int,
    release: String,
    rating: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier
            .width(160.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    ) {
        Column (
            modifier = Modifier
                .background(Color(0xFF1E2747))
            ) {
            Image(
                painter = painterResource(poster),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = title,
                        color = Color.White,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(top = 2.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp, end= 4.dp)
                    ){
                        Text(
                            text = rating,
                            color = Color.White.copy(alpha = 0.7f),
                            style = MaterialTheme.typography.titleSmall,
                            modifier = Modifier
                                .padding(end = 2.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.star),
                            contentDescription = "star",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .height(16.dp)
                        )
                        Text(
                            text = release,
                            color = Color.White.copy(alpha = 0.7f),
                            style = MaterialTheme.typography.titleSmall,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .padding(start = 24.dp)
                                .fillMaxWidth())
                    }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MovieItemPreview() {
    MaterialTheme {
        MovieItem(R.drawable.poster6, "2023", "8.9", "Jhon Wick: Chapter 4")
    }
}
