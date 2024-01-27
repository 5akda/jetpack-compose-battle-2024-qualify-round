package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.screen.MyTopBar
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify3Screen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ProfileTopBar() }
    ) { innerPadding ->
        ProfileContent(padding = innerPadding)
    }
}

@Composable
private fun ProfileTopBar() {
    MyTopBar(
        leftLayout = {
            Image(
                painter = painterResource(id = R.drawable.ic_qualify_3_back),
                contentDescription = null
            )
        },
        title = "John Doe",
        rightLayout = {
            Image(
                painter = painterResource(id = R.drawable.ic_qualify_3_copy),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.ic_qualify_3_calendar),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.ic_qualify_3_menu),
                contentDescription = null
            )
        }
    )
}

@Composable
private fun ProfileContent(padding: PaddingValues) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onPrimary)
            .padding(padding)
            .fillMaxSize()
    ) {
        val selectedTagIndex by remember { mutableIntStateOf(0) }
        ProfileContentImageSection(
            modifier = Modifier.padding(top = 16.dp),
            images = listOf(R.drawable.img_qualify_3_photo_1, R.drawable.img_qualify_3_photo_2, R.drawable.img_qualify_3_photo_3)
        )
        ProfileContentTagSection(
            modifier = Modifier.padding(top = 16.dp),
            tags = listOf("Tag 1", "Tag 2", "Tag 3", "Tag 4"),
            selectedIndex = selectedTagIndex
        )
        ProfileContentMessageSection(
            modifier = Modifier.padding(top = 16.dp),
            messages = listOf(
                "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh.",
                "Morbi sed sagittis justo, at pulvinar ipsum. Praesent massa metus, interdum at suscipit a, interdum vel orci. Pellentesque in sapien. Integer faucibus mauris ac luctus aliquam accumsan.",
                "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo.",
                "Ut hendrerit neque nec accumsan hendrerit. Fusce lobortis rhoncus erat, a blandit nibh molestie vel. Cras commodo ligula ex, vitae venenatis lacus facilisis eget."
            )
        )
    }
}

@Composable
private fun ProfileContentImageSection(modifier: Modifier, images: List<Int>) {
    LazyRow(
        modifier = modifier,
        state = rememberLazyListState()
    ) {
        itemsIndexed(images) { index, imageId ->
            val color = if (index == 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer

            Image(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(160.dp)
                    .height(320.dp)
                    .border(width = 2.dp, color = color, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp)),
                painter = painterResource(id = imageId),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun ProfileContentTagSection(modifier: Modifier, tags: List<String>, selectedIndex: Int) {
    LazyRow(
        modifier = modifier,
        state = rememberLazyListState()
    ) {
        itemsIndexed(tags) { index, tagName ->
            val startPadding = if (index == 0) 16.dp else 8.dp
            val color = if (index == selectedIndex) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline

            Box(
                modifier = Modifier
                    .padding(start = startPadding)
                    .size(width = 68.dp, height = 32.dp)
                    .border(width = 1.dp, color = color, shape = RoundedCornerShape(8.dp))
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = tagName,
                    color = color,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Composable
private fun ProfileContentMessageSection(modifier: Modifier, messages: List<String>) {
    Column(modifier = modifier) {
        messages.forEach { message ->
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .fillMaxWidth()
                    .height(96.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            ) {
                Image(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(48.dp),
                    painter = painterResource(id = R.drawable.img_qualify_3_sender),
                    contentDescription = null
                )
                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        text = "Lorem Ipsum",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = message,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 2,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() = AppTheme {
    Qualify3Screen()
}
// endregion