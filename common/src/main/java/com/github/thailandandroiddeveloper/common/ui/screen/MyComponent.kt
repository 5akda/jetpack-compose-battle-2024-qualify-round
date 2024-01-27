package com.github.thailandandroiddeveloper.common.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun TextStyle.makeItSimilarToOriginalImage(isEnabled: Boolean = true): TextStyle {
    val magicNumber = 0.5
    return if (isEnabled) this.copy(letterSpacing = magicNumber.sp) else this
}

@Composable
fun MyTopBar(
    leftLayout: @Composable RowScope.() -> Unit = {},
    rightLayout: @Composable RowScope.() -> Unit = {},
    title: String = "",
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(horizontal = 4.dp, vertical = 8.dp)

    ) {
        Row(content = leftLayout)
        Text(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .padding(horizontal = 4.dp),
            text = title,
            style = MaterialTheme.typography.titleLarge.makeItSimilarToOriginalImage(),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Row(content = rightLayout)
    }
}

@Composable
fun MyBottomAction(onClick: () -> Unit, content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(102.dp)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .padding(horizontal = 80.dp, vertical = 31.dp)
    ) {
        Button(
            modifier = Modifier.fillMaxSize(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            onClick = onClick,
            content = content
        )
    }
}