package org.khawthwarmal.burmesehandsign.dictionary.ui.screen.word

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.khawthwarmal.burmesehandsign.core.models.Example
import org.khawthwarmal.burmesehandsign.core.ui.compose.imageResource
import org.khawthwarmal.burmesehandsign.core.ui.compose.pagerHorizontalCarousel
import org.khawthwarmal.burmesehandsign.core.ui.theme.headerStyle

@ExperimentalFoundationApi
@Composable
fun ExamplesLayout(
    data: List<Example>,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        val pagerState = rememberPagerState()
        Text(
            text = "Examples",
            style = headerStyle().copy(fontSize = 18.sp),
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 24.dp)
        )
        HorizontalPager(
            pageCount = data.count(),
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 32.dp),
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            ExampleItem(
                data = data[page],
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.53f)
                    .pagerHorizontalCarousel(pagerState) { page }
            )
        }
    }
}

@Composable
fun ExampleItem(
    data: Example,
    modifier: Modifier = Modifier
) {
    val image = when(data) {
        is Example.Image -> data.data
    }
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp)
    ) {
        Image(
            painter = imageResource(resource = image),
            contentDescription = "example image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
