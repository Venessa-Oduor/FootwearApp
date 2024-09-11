package com.venessa.footwearapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.venessa.footwearapp.ui.theme.Screens.Home.HomeScreen
import com.venessa.footwearapp.ui.theme.Screens.Login.LoginScreen
import com.venessa.footwearapp.ui.theme.Screens.Product.ProductScreen
import com.venessa.footwearapp.ui.theme.Screens.Productdetail.ProductDetailScreen
import com.venessa.footwearapp.ui.theme.Screens.Register.RegisterScreen
import com.venessa.footwearapp.ui.theme.Screens.Splash.SplashScreen



@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_SPLASH) {
    NavHost(navController=navController,modifier=Modifier,startDestination=startDestination){
        composable(ROUTE_SPLASH){
            SplashScreen(navController)
        }
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_PRODUCT){
            ProductScreen(navController)
        }
        composable("${ROUTE_PRODUCT_DETAILS}/{id}", arguments = listOf(navArgument("id"){type=
            NavType.StringType})){
            val id=it.arguments?.getString("id")
            if (id!=null)
            ProductDetailScreen(id, navController)
        }
//        composable(ROUTE_PRODUCT_DETAILS +"/{id}") { passedData ->
//            ProductDetailScreen(navController.toString(),passedData.arguments?.getString("id")!!)
//        }


    }
}


