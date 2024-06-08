package com.example.cinemate.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemate.R
import com.example.cinemate.ui.theme.CinemateTheme

@Composable
fun Profile(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier){
        val columnModifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E2747))
            .padding(8.dp)
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .fillMaxWidth()
                .background(Color(0xFF141A32)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.profile),
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(top = 32.dp,  bottom = 32.dp)
            )
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            Text(
                text =stringResource(R.string.name),
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(top = 16.dp,  bottom = 16.dp)
            )
            ElevatedCard(
                modifier = modifier.padding(start = 24.dp, end = 24.dp , top = 8.dp, bottom = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background,
                ),
            ) {
                Column (
                    modifier = columnModifier
                ) {
                    Text(
                        text =stringResource(R.string.profile_email),
                        color = Color.White.copy(alpha = 0.5f),
                        fontSize = 17.sp,
                        modifier = Modifier
                            .padding(bottom = 4.dp)

                    )
                    Text(
                        text =stringResource(R.string.email),
                        color = Color.White,
                        fontSize = 17.sp,
                        modifier = Modifier
                    )
                }
            }
            ElevatedCard(
                modifier = modifier.padding(start = 24.dp, end = 24.dp , top = 8.dp, bottom = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background,
                ),
            ) {
                Column (
                    modifier = columnModifier
                ) {
                    Text(
                        text =stringResource(R.string.profile_kampus),
                        color = Color.White.copy(alpha = 0.5f),
                        fontSize = 17.sp,
                        modifier = Modifier
                            .padding(bottom = 4.dp)

                    )
                    Text(
                        text =stringResource(R.string.kampus),
                        color = Color.White,
                        fontSize = 17.sp,
                        modifier = Modifier
                    )
                }
            }
            ElevatedCard(
                modifier = modifier.padding(start = 24.dp, end = 24.dp , top = 8.dp, bottom = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background,
                ),
            ) {
                Column (
                    modifier = columnModifier
                ) {
                    Text(
                        text =stringResource(R.string.profile_path),
                        color = Color.White.copy(alpha = 0.5f),
                        fontSize = 17.sp,
                        modifier = Modifier
                            .padding(bottom = 4.dp)

                    )
                    Text(
                        text =stringResource(R.string.path),
                        color = Color.White,
                        fontSize = 17.sp,
                        modifier = Modifier
                    )
                }
            }
            ElevatedCard(
                modifier = modifier.padding(start = 24.dp, end = 24.dp , top = 8.dp, bottom = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background,
                ),
            ) {
                Column (
                    modifier = columnModifier
                ) {
                    Text(
                        text =stringResource(R.string.profile_program),
                        color = Color.White.copy(alpha = 0.5f),
                        fontSize = 17.sp,
                        modifier = Modifier
                            .padding(bottom = 4.dp)

                    )
                    Text(
                        text =stringResource(R.string.program),
                        color = Color.White,
                        fontSize = 17.sp,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ProfileCinemateAppPreview() {
    CinemateTheme {
        Profile()
    }
}
