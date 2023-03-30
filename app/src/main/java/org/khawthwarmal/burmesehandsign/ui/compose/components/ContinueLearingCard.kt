package org.khawthwarmal.burmesehandsign.ui.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.khawthwarmal.burmesehandsign.core.ui.theme.headerStyle
import org.khawthwarmal.burmesehandsign.core.ui.theme.mediumBodyStyle

@Composable
fun ContinueLearningCard(
    data: ContinueLearningData,
    onClick: (ContinueLearningData) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF414141), Color(0xFF232023)),
                    start = Offset(250f, 0f),
                    end = Offset(550f, 700f)
                ),
                shape = RoundedCornerShape(20.dp)
            )
            .clickable(onClick = { onClick(data) })
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            /* Chapter Title */
            Text(
                text = data.chapterTitle,
                style = headerStyle().copy(color = Color.White)
            )
            /* Course Title */
            Text(
                text = data.courseTitle,
                style = mediumBodyStyle().copy(color = Color.White)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ContinueLearningCardPreview() {
    val data = ContinueLearningData(
        "Chapter 2 : Numbers",
        courseTitle = "Grade 1 - Burmese",
        percentage = 0.5f
    )
    ContinueLearningCard(
        data = data,
        onClick = { }
    )
}


data class ContinueLearningData(
    val chapterTitle: String,
    val courseTitle: String,
    val percentage: Float
) {
    companion object {
        fun fromChapter() {

        }
    }
}