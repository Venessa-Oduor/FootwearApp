package com.venessa.footwearapp.ui.theme.Screens.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.venessa.footwearapp.R
import com.venessa.footwearapp.navigation.ROUTE_LOGIN
import com.venessa.footwearapp.navigation.ROUTE_REGISTER

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context= LocalContext.current
//        var productdata=productviewmodel(navController,context)
        Spacer(modifier = Modifier.height(100.dp))

        Image(
            painter= painterResource(id = R.drawable.shoelogo), contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .background(Color.White)
        )
        Spacer(modifier = Modifier.height(100.dp))

        Text(text = "Welcome to Footwear",
            color = Color.Black,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = {
            navController.navigate(ROUTE_REGISTER)

        },modifier = Modifier.width(250.dp),
        colors= ButtonDefaults.buttonColors(Color.Black)) {
            Text(
                text = "Register",
                color=Color.White)
        }
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)

        },modifier = Modifier.width(250.dp),
            colors= ButtonDefaults.buttonColors(Color.Black)) {
            Text(text = "login",
                color = Color.White)
        }
    }
}

@Preview
@Composable
fun Homepreview() {
    HomeScreen(rememberNavController())
}