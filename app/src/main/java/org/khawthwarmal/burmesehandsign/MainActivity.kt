package org.khawthwarmal.burmesehandsign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.khawthwarmal.burmesehandsign.ui.screens.home.HomeScreenDestinations
import org.khawthwarmal.burmesehandsign.ui.screens.learn.LearnScreen
import org.khawthwarmal.burmesehandsign.core.ui.theme.BurmeseHandSignTheme
import org.khawthwarmal.burmesehandsign.core.ui.theme.LightGrey
import org.khawthwarmal.burmesehandsign.core.ui.theme.semiBoldBodyStyle
import org.khawthwarmal.burmesehandsign.dictionary.ui.screen.dictionary.DictionaryScreen
import org.khawthwarmal.burmesehandsign.dictionary.ui.screen.word.detail.WordDetailScreen

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BurmeseHandSignTheme {
                val navController = rememberNavController()
                val items = listOf(
                    HomeScreenDestinations.Learning,
                    HomeScreenDestinations.Dictionary
                )
                Scaffold(
                    bottomBar = {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        val isBottomNavVisible by remember {
                            derivedStateOf {
                                val currentRoute = navBackStackEntry?.destination?.route
                                currentRoute in items.map(HomeScreenDestinations::route) + "home"
                            }
                        }
                        AnimatedVisibility(
                            visible = isBottomNavVisible,
                            enter = slideInVertically { it } + fadeIn(),
                            exit = slideOutVertically { it } + fadeOut()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.White)
                                    .padding(horizontal = 20.dp)
                            ) {
                                items.forEach { screen ->
                                    val isSelected =
                                        currentDestination?.hierarchy?.any { it.route == screen.route } == true
                                    val buttonColor by animateColorAsState(
                                        targetValue = if (isSelected) {
                                            Color.Black
                                        } else {
                                            Color.White
                                        }
                                    )
                                    val contentColor by animateColorAsState(
                                        targetValue = if (isSelected) {
                                            Color.White
                                        } else {
                                            LightGrey
                                        }
                                    )
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(vertical = 20.dp)
                                            .padding(horizontal = 8.dp)
                                            .clip(RoundedCornerShape(50.dp))
                                            .background(buttonColor)
                                            .clickable {
                                                navController.navigate(screen.route) {
                                                    popUpTo(navController.graph.findStartDestination().id) {
                                                        saveState = true
                                                    }
                                                    launchSingleTop = true
                                                    restoreState = true
                                                }
                                            }
                                    ) {
                                        Row(
                                            Modifier.padding(
                                                vertical = 16.dp,
                                                horizontal = 16.dp
                                            )
                                        ) {
                                            Icon(
                                                painter = painterResource(id = screen.iconResId),
                                                contentDescription = null,
                                                modifier = Modifier.size(24.dp),
                                                tint = contentColor
                                            )
                                            Spacer(Modifier.width(16.dp))
                                            Text(
                                                text = stringResource(id = screen.screenName),
                                                color = contentColor,
                                                style = semiBoldBodyStyle()
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                ) { _ ->
                    NavHost(
                        navController = navController,
                        startDestination = "learn"
                    ) {
                        navigation("home", route = "learn") {
                            composable("home") {
                                LearnScreen(
                                    navigateToWordDetail = {}
                                )
                            }
                            composable("word/{ID}") {
                                WordDetailScreen(
                                    id = it.arguments?.getString("ID", "က")!!,
                                    onTapBack = navController::popBackStack
                                )
                            }
                        }
                        composable("dictionary") {
                            DictionaryScreen(
                                navigateToWordDetail = {
                                    navController.navigate(
                                        route = "word/$it",
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BurmeseHandSignTheme {

    }
}