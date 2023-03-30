package org.khawthwarmal.burmesehandsign.ui.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.khawthwarmal.burmesehandsign.core.R
import org.khawthwarmal.burmesehandsign.core.ui.theme.LightGrey
import org.khawthwarmal.burmesehandsign.core.ui.theme.SurfaceGrey

@Composable
fun ActionBar(
    onTapBack: () -> Unit
) {
    Box(
       modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        BackButton(onClick = onTapBack)
    }
}

@Composable
fun BackButton(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = SurfaceGrey)
            .clickable { onClick() }

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "Back",
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 16.dp)
                .absolutePadding(left = 8.dp),
            colorFilter = ColorFilter.tint(LightGrey)
        )
    }
}


@Preview
@Composable
fun PreviewActionBar() {
    ActionBar(onTapBack = {})
}