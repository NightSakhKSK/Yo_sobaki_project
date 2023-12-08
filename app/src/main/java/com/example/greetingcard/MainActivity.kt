package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "greeting/message={message}&from={from}") {
        composable(
            "greeting/message={message}&from={from}",
            arguments = listOf(
                navArgument("message") { type = NavType.StringType },
                navArgument("from") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            GreetingScreen(
                message = backStackEntry.arguments?.getString("message") ?: stringResource(id = R.string.yo_sobaki1),
                from = backStackEntry.arguments?.getString("from") ?: stringResource(id = R.string.from_ksk),
                navController = navController
            )
        }
        composable("hamsterScreen") { HamsterScreen(navController) }
    }
}



@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    GreetingCardTheme {
        val navController = rememberNavController()
//        AppNavigation()
//        GreetingScreen(message = stringResource(id = R.string.yo_sobaki1),
//            from = stringResource(id = R.string.from_ksk),
//            navController = navController);
        HamsterScreen(navController)
    }
}
