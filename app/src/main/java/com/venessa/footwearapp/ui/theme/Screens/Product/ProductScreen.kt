package com.venessa.footwearapp.ui.theme.Screens.Product

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.venessa.footwearapp.R
import com.venessa.footwearapp.model.Product
import com.venessa.footwearapp.navigation.ROUTE_PRODUCT_DETAILS
import com.venessa.footwearapp.ui.theme.Screens.components.ProductItem




@Composable
fun ProductScreen(navController: NavHostController) {
    val products = remember{
        getProductList()

    }
        LazyVerticalGrid(columns =GridCells.Fixed(2),modifier=Modifier.padding(8.dp) ) {
            items(products){
                ProductItem(product=it){
                    navController.navigate("$ROUTE_PRODUCT_DETAILS/${(it.id)}")
//                    navController.navigate(ROUTE_PRODUCT_DETAILS)
                }

            }


        }

}


fun getProductList(): List<Product>{
    return listOf(
        Product(
            id ="1",
            color= Color.Magenta,
            price= "5000",
            name="Jordan 3",
            discountprice = "4500",
            rating = 4.7,
            imageRes = R.drawable.j3c,
            size = 6
        ),
        Product(
            id ="2",
            color= Color.Red,
            price= "3500",
            name="Adidas",
            discountprice = "2500",
            rating = 4.5,
            imageRes = R.drawable.adidas1,
            size = 8
        ),
        Product(
            id ="3",
            color= Color.Cyan,
            price= "3500",
            name="AirForce1",
            discountprice="2500",
            rating = 3.5,
            imageRes = R.drawable.airforce,
            size = 6
        ),
        Product(
            id ="4",
            color= Color.Yellow,
            price= "3000",
            name="Vans",
            discountprice = "1500",
            rating = 5.5,
            imageRes = R.drawable.vans,
            size = 8
        ),
        Product(
            id ="5",
            color= Color.Magenta,
            price= "2200",
            name="Converse Low cut",
            discountprice = "1500",
            rating = 4.5,
            imageRes = R.drawable.converse,
            size = 6
        ),
        Product(
            id ="6",
            color= Color.Blue,
            price= "5000",
            name="Canvas Platform",
            discountprice = "4500",
            rating = 4.5,
            imageRes = R.drawable.canvasplatform,
            size = 6
        ),
        Product(
            id ="7",
            color= Color.Green,
            price= "5000",
            name="Air Max",
            discountprice = "4500",
            rating = 4.5,
            imageRes = R.drawable.airmax1,
            size = 6
        ),
        Product(
            id ="8",
            color= Color.Gray,
            price= "5000",
            name="Canvas Platform",
            discountprice = "4500",
            rating = 4.5,
            imageRes = R.drawable.canvasplatform,
            size = 6
        ),
        Product(
            id ="9",
            color= Color.Red,
            price= "5000",
            name="Yeezy",
            discountprice = "4500",
            rating = 4.5,
            imageRes = R.drawable.yeezy2,
            size = 6
        ),




    )
}

@Preview
@Composable
fun Productpage() {
    ProductScreen(navController = rememberNavController())


}