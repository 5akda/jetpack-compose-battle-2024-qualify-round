package com.github.thailandandroiddeveloper.common.ui.screen.qualify2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.screen.MyBottomAction
import com.github.thailandandroiddeveloper.common.ui.screen.makeItSimilarToOriginalImage
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify2Screen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { TutorialBottomAction() }
    ) { innerPadding ->
        TutorialContent(padding = innerPadding)
    }
}

@Composable
private fun TutorialBottomAction() {
    MyBottomAction(onClick = {}) {
        Text(
            text = "Next",
            style = MaterialTheme.typography.labelLarge.makeItSimilarToOriginalImage(),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
private fun TutorialContent(padding: PaddingValues) {
    Box(
        modifier = Modifier.padding(padding)
            .background(color = MaterialTheme.colorScheme.onPrimary)
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(horizontal = 20.dp, vertical = 18.dp),
            text = "Skip",
            style = MaterialTheme.typography.labelLarge.makeItSimilarToOriginalImage(),
            color = MaterialTheme.colorScheme.primary
        )
        Column(
            modifier = Modifier.padding(top = 64.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                text = "Lorem ipsum dolor sit amet",
                style = MaterialTheme.typography.headlineSmall.makeItSimilarToOriginalImage(),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .padding(top = 16.dp),
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec egestas dictum lacinia. Integer arcu neque, porttitor ac metus quis, iaculis molestie magna. Vivamus molestie justo sed nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla",
                style = MaterialTheme.typography.bodyMedium.makeItSimilarToOriginalImage(),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
        }
        Image(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(shape = RoundedCornerShape(16.dp))
                .padding(horizontal = 32.dp)
                .padding(bottom = 98.dp)
                .height(446.dp),
            painter = painterResource(id = R.drawable.img_qualify_2_onboard),
            contentDescription = null
        )
        Row(
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(bottom = 48.dp)
        ) {
            val pages = listOf(false, false, false, true, false)
            pages.forEach { isSelected ->
                if (isSelected) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .width(32.dp)
                            .height(16.dp)
                            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(50))
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .width(16.dp)
                            .height(16.dp)
                            .background(MaterialTheme.colorScheme.primaryContainer, CircleShape)
                    )
                }
            }
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify2ScreenPreview() = AppTheme {
    Qualify2Screen()
}
// endregion