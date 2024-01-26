package com.github.thailandandroiddeveloper.common.ui.screen.qualify1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.screen.MyTopBar
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify1Screen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MainTopBar() }
    ) { innerPadding ->
        MainContent(padding = innerPadding)
    }
}

@Composable
private fun MainTopBar() {
    MyTopBar(
        leftLayout = {
            Image(
                painter = painterResource(id = R.drawable.ic_qualify_1_menu),
                contentDescription = null
            )
        },
        rightLayout = {
            Image(
                painter = painterResource(id = R.drawable.ic_qualify_1_profile),
                contentDescription = null
            )
        }
    )
}

@Composable
private fun MainContent(padding: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onPrimary)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 48.dp)
    ) {
        Image(
            modifier = Modifier
                .padding(bottom = 24.dp)
                .clip(RoundedCornerShape(16.dp)),
            painter = painterResource(id = R.drawable.img_qualify_1_profile),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .padding(bottom = 24.dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.75f))
                .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 40.dp)
        ) {
            Text(
                modifier = Modifier.background(color = Color.Transparent),
                text = "John Doe",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineMedium,
            )
            Row {
                Image(
                    modifier = Modifier.padding(top = 10.dp),
                    painter = painterResource(id = R.drawable.ic_qualify_1_gender_male),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                    text = "Male",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "Lorem ipsum dolor sit amet, cd nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla.",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Button(
                modifier = Modifier
                    .padding(start = 48.dp)
                    .width(120.dp)
                    .height(48.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_qualify_1_thumb_down),
                    contentDescription = null
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            Button(
                modifier = Modifier
                    .padding(end = 48.dp)
                    .width(120.dp)
                    .height(48.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_qualify_1_thumb_up),
                    contentDescription = null
                )
            }
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify1ScreenPreview() = AppTheme {
    Qualify1Screen()
}
// endregion