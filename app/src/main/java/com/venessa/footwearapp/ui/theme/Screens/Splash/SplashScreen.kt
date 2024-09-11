package com.venessa.footwearapp.ui.theme.Screens.Splash

import android.graphics.fonts.FontFamily
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.venessa.footwearapp.R
import com.venessa.footwearapp.navigation.ROUTE_HOME
import kotlinx.coroutines.delay
@Composable

fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Centered image
            val splashImage: Painter = painterResource(id = R.drawable.shoelogo)

            Image(
                painter = splashImage,
                contentDescription = "Splash Screen",
                modifier = Modifier.size(400.dp) // Adjust size as needed
            )

            Spacer(modifier = Modifier.height(16.dp)) // Adjust this value to control the space between the image and the text

            // Text closer to the center
            Text(
                text = "FOOTWEAR",
                fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
                fontSize = 50.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }

    // Simulate loading delay
    LaunchedEffect(Unit) {
        delay(2000) // 2 seconds delay
        navController.navigate(ROUTE_HOME)
    }
}






@Preview
@Composable
fun splashpage() {
    SplashScreen(navController = rememberNavController())

}