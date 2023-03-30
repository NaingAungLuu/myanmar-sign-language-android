package org.khawthwarmal.burmesehandsign.ui.screens.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.khawthwarmal.burmesehandsign.core.R

sealed class HomeScreenDestinations(
    val route: String,
    @DrawableRes val iconResId: Int,
    @StringRes val screenName: Int
) {
    object Learning : HomeScreenDestinations("learn", R.drawable.ic_learn, R.string.nav_learn)
    object Dictionary : HomeScreenDestinations("dictionary", R.drawable.ic_dictionary, R.string.nav_dictionary)
}