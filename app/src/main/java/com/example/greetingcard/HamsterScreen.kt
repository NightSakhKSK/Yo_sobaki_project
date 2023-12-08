package com.example.greetingcard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun HamsterScreen(navController: NavController) {
    val image = painterResource(id = R.drawable.hamster3) // Replace with your image resource
    val clickCount = remember{ mutableIntStateOf(0) }
    Box(modifier = Modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.7F)
        )
        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = { navController.navigate("greeting/message=YourMessage&from=YourName") }) {
            Text("Back to the First Screen")
        }
        Button(onClick =  {clickCount.intValue++} ) {
            Text("Click me: ${clickCount.intValue} times")
        }
    }
}