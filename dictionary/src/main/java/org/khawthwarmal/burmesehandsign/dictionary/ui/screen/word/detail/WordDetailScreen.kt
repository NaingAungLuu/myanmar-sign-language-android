package org.khawthwarmal.burmesehandsign.dictionary.ui.screen.word.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.serialization.ExperimentalSerializationApi
import org.khawthwarmal.burmesehandsign.core.ui.theme.headerStyle
import org.khawthwarmal.burmesehandsign.dictionary.ui.screen.word.DefinitionLayout
import org.khawthwarmal.burmesehandsign.dictionary.ui.screen.word.ExamplesLayout
import org.khawthwarmal.burmesehandsign.dictionary.ui.screen.word.WordDescription
import org.khawthwarmal.burmesehandsign.ui.compose.components.ActionBar

@OptIn(ExperimentalFoundationApi::class, ExperimentalSerializationApi::class)
@Composable
fun WordDetailScreen(
    id: String = "က",
    onTapBack: () -> Unit,
    viewModel: WordDetailViewModel = hiltViewModel()
) {

    val word = viewModel.getWord(id).collectAsState(initial = null)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()) 
    ) {
        ActionBar(onTapBack)
        Spacer(modifier = Modifier.height(20.dp))

        HeaderText(word.value?.title.orEmpty())
        Spacer(modifier = Modifier.height(20.dp))

        word.value?.definition?.let {
            DefinitionLayout(it)
        }

        WordDescription(word.value?.description.orEmpty())
        Spacer(modifier = Modifier.height(20.dp))

        ExamplesLayout(word.value?.examples ?: emptyList())
        Spacer(modifier = Modifier.height(64.dp))
    }
}

@Composable
private fun HeaderText(
    text: String
) {
    Text(
        text = text,
        style = headerStyle().copy(fontSize = 32.sp),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Preview(heightDp = 1000)
@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun PreviewWordDetailScreen() {
    WordDetailScreen("က", {})
}