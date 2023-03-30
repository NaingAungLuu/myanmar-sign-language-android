package org.khawthwarmal.burmesehandsign.ui.screens.learn


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.khawthwarmal.burmesehandsign.core.R
import org.khawthwarmal.burmesehandsign.core.ui.theme.Purple40
import org.khawthwarmal.burmesehandsign.core.ui.theme.SurfaceGrey
import org.khawthwarmal.burmesehandsign.core.ui.theme.boldTitleStyle
import org.khawthwarmal.burmesehandsign.core.ui.theme.headerStyle
import org.khawthwarmal.burmesehandsign.core.ui.theme.mediumBodyStyle
import org.khawthwarmal.burmesehandsign.core.ui.theme.semiBoldBodyStyle
import org.khawthwarmal.burmesehandsign.ui.compose.components.ContinueLearningCard
import org.khawthwarmal.burmesehandsign.ui.compose.components.ContinueLearningData

@Composable
fun LearnScreen(
    navigateToWordDetail: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White
    ) {
        val data = ContinueLearningData(
            "Start Learning",
            courseTitle = "to see your progress!",
            percentage = 0.5f
        )
        Column(Modifier.fillMaxSize()) {
            TopBar()
            ContinueLearningCard(
                data = data,
                onClick = {},
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(Modifier.height(16.dp))
//            Text(
//                text = "Courses",
//                style = headerStyle(),
//                modifier = Modifier.padding(start = 20.dp)
//            )
            Spacer(Modifier.weight(1f))

            Column(Modifier.offset(y = 24.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .padding(end = 36.dp, start = 36.dp, top = 16.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(SurfaceGrey)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_learn),
                        contentDescription = null,
                        modifier = Modifier
                            .width(160.dp)
                            .align(Alignment.CenterStart)
                            .padding(start = 16.dp)
                    )
                    Column(
                        modifier = Modifier
                            .wrapContentWidth()
                            .align(Alignment.CenterEnd)
                            .padding(end = 24.dp, top = 24.dp, bottom = 8.dp)
                    ) {
                        Text(
                            text = "Courses are coming soon . . .",
                            style = semiBoldBodyStyle().copy(color = Color.Black)
                        )
                        Text(
                            text = "   Try out the\nHand Sign Dictionary!",
                            style = headerStyle().copy(color = Color.Black, fontSize = 20.sp)
                        )
                    }
                }
                Image(
                    painter = painterResource(id = org.khawthwarmal.burmesehandsign.dictionary.R.drawable.ic_down_arrow),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier
                        .width(140.dp)
                        .align(Alignment.End)
                        .padding(end = 86.dp)
                        .offset(y = (-18).dp)
                )
            }
            Spacer(Modifier.height(100.dp))
        }
    }
}

@Composable
private fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GreetingText()
        Spacer(Modifier.weight(1f))
        ProfileButton()
    }
}

@Composable
fun GreetingText() {
    Text(
        text = "Hi, Harry 🌙",
        style = headerStyle(),
        modifier = Modifier.padding(20.dp)
    )
}

@Composable
fun ProfileButton() {
    Box(
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(SurfaceGrey)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .padding(12.dp)
        )
    }
}

@Composable
fun CourseItem(
    data: Course,
    onTapItem: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(25.dp))
            .clickable { onTapItem() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Image(
                painter = ColorPainter(Purple40),
                contentDescription = null,
                modifier = Modifier
                    .weight(0.5f)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(20.dp))
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(Modifier.weight(1f)) {
                Spacer(Modifier.height(8.dp))
                Text(
                    text = data.title,
                    style = boldTitleStyle()
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = data.description,
                    style = mediumBodyStyle()
                )
            }
        }
    }
}

data class Course(
    val title: String,
    val description : String,
    @DrawableRes val imageId: Int
)