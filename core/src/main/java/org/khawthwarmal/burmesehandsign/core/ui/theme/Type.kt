package org.khawthwarmal.burmesehandsign.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.unit.sp
import org.khawthwarmal.burmesehandsign.core.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

@Composable
fun headerStyle(): TextStyle = TextStyle(
    fontFamily = poppinsFontFamily(),
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp
)

@Composable
fun boldTitleStyle(): TextStyle = TextStyle(
    fontFamily = poppinsFontFamily(),
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp
)

@Composable
fun semiBoldBodyStyle(): TextStyle = TextStyle(
    fontFamily = poppinsFontFamily(),
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    baselineShift = BaselineShift(-0.1f)
)

@Composable
fun mediumBodyStyle(): TextStyle = TextStyle(
    fontFamily = poppinsFontFamily(),
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
)

@Composable
fun thinBodyStyle(): TextStyle = TextStyle(
    fontFamily = poppinsFontFamily(),
    fontWeight = FontWeight.Thin,
    fontSize = 14.sp
)

@Composable
fun poppinsFontFamily(): FontFamily = FontFamily(
    fonts = listOf(
        poppinsThin(),
        poppinsRegular(),
        poppinsMedium(),
        poppinsSemiBold(),
        poppinsBold()
    )
)

@Composable
fun poppinsThin() : Font = Font(
    resId = R.font.poppins_thin,
    weight = FontWeight.Thin,
    style = FontStyle.Normal
)

@Composable
fun poppinsMedium() : Font = Font(
    resId = R.font.poppins_medium,
    weight = FontWeight.Medium,
    style = FontStyle.Normal
)

@Composable
fun poppinsRegular() : Font = Font(
    resId = R.font.poppins,
    weight = FontWeight.Medium,
    style = FontStyle.Normal
)


@Composable
fun poppinsSemiBold() : Font = Font(
    resId = R.font.poppins_semibold,
    weight = FontWeight.SemiBold,
    style = FontStyle.Normal
)


@Composable
fun poppinsBold() : Font = Font(
    resId = R.font.poppins_bold,
    weight = FontWeight.Bold,
    style = FontStyle.Normal
)

@Composable
fun notoSan() : Font = Font(
    resId = R.font.noto_sans,
    weight = FontWeight.Medium,
    style = FontStyle.Normal
)