package org.khawthwarmal.burmesehandsign.dictionary.ui.screen.dictionary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import org.khawthwarmal.burmesehandsign.core.models.Word
import org.khawthwarmal.burmesehandsign.core.ui.compose.imageResource
import org.khawthwarmal.burmesehandsign.core.ui.theme.SurfaceGrey
import org.khawthwarmal.burmesehandsign.core.ui.theme.boldTitleStyle
import org.khawthwarmal.burmesehandsign.core.ui.theme.headerStyle

@Composable
fun DictionaryScreen(
    navigateToWordDetail: (String) -> Unit,
    viewModel: DictionaryViewModel = hiltViewModel()
) {
    val dictionary = viewModel.getDictionary().collectAsState(initial = null)
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White
    ) {
        Column(Modifier.fillMaxSize()) {
            TopBar()
            dictionary.value?.words?.let { words ->
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(bottom = 86.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(words) {
                        DictionaryItem(
                            data = it,
                            modifier = Modifier.fillMaxSize(),
                            onTapItem = { navigateToWordDetail(it.title) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Dictionary",
            style = headerStyle(),
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
private fun DictionaryItem(
    data: Word,
    onTapItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(SurfaceGrey)
            .clickable { onTapItem() }
    ) {
        Image(
            painter = imageResource(resource = data.definition.handSign),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .padding(start = 12.dp, end = 12.dp, top = 12.dp)
                .clip(RoundedCornerShape(15.dp))
        )
        Text(
            text = data.title,
            style = boldTitleStyle().copy(fontSize = 32.sp),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}